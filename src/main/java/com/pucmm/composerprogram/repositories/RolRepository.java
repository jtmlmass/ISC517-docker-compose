package com.pucmm.composerprogram.repositories;


import com.pucmm.composerprogram.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RolRepository extends JpaRepository<Rol, String> {

}
