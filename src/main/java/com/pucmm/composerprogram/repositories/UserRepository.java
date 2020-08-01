package com.pucmm.composerprogram.repositories;

import com.pucmm.composerprogram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
