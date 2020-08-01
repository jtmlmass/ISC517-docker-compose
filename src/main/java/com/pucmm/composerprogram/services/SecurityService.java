package com.pucmm.composerprogram.services;

import com.pucmm.composerprogram.entities.Poll;
import com.pucmm.composerprogram.entities.Rol;
import com.pucmm.composerprogram.entities.User;
import com.pucmm.composerprogram.repositories.PollRepository;
import com.pucmm.composerprogram.repositories.RolRepository;
import com.pucmm.composerprogram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PollRepository pollRepository;

    //Para encriptar la información del Usuario
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void createAdmin() {
        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepository.save(rolAdmin);
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setRoles(new HashSet<>(Collections.singletonList(rolAdmin)));
        admin.setActive(true);
        userRepository.save(admin);
    }

    public void createUsers(){
        Rol rolUser = new Rol("ROLE_USER");
        rolRepository.save(rolUser);
        User user = new User();
        user.setUsername("user");
        user.setPassword(bCryptPasswordEncoder.encode("user"));
        user.setActive(true);
        user.setRoles(new HashSet<>(Collections.singletonList(rolUser)));
        userRepository.save(user);
    }

    public void createPolls(){
        User user = userRepository.findByUsername("user");
        for (int i = 0; i < 10; i++) {
            Poll poll = new Poll(0, "¿Las charlas donde usted participó cumplieron con sus expectativas?",
                    "¿Los expositores mostraron tener dominio del tema?",
                    "¿Las instalaciones del evento fueron comfortables para usted?",
                    "¿Las charlas donde usted participó cumplieron con sus expectativas?",
                    ThreadLocalRandom.current().nextInt(1, 5 + 1),
                    ThreadLocalRandom.current().nextInt(1, 5 + 1),
                    ThreadLocalRandom.current().nextInt(1, 5 + 1),
                    ThreadLocalRandom.current().nextInt(1, 5 + 1),
                    user);
            pollRepository.save(poll);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, grantedAuthorities);
    }
}
