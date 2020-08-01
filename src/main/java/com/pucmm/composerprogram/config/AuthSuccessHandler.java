package com.pucmm.composerprogram.config;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pucmm.composerprogram.entities.User;
import com.pucmm.composerprogram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user;
        if(authentication.getPrincipal() instanceof Principal) {
             String username = ((Principal) authentication.getPrincipal()).getName();
             user = userRepository.findByUsername(username);

        }else {
            String username = ((UserDetails)authentication.getPrincipal()).getUsername();
            user = userRepository.findByUsername(username);
        }
        session.setAttribute("user", user);
        response.sendRedirect("/");
    }
}