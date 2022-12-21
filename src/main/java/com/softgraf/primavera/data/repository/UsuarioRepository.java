package com.softgraf.primavera.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softgraf.primavera.data.entity.Usuario;

@Repository					
public interface UsuarioRepository extends JpaRepository<Usuario, String>  {

}
