package org.morocho.springcloud.msvc.usuarios.repository;

import org.morocho.springcloud.msvc.usuarios.models.entitiy.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
}
