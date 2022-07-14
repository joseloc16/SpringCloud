package org.morocho.springcloud.msvc.usuarios.service;

import org.morocho.springcloud.msvc.usuarios.models.entitiy.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
  List<Usuario> findAll();
  Optional<Usuario> findByIdUsuario(Long id);
  Usuario saveUsuario(Usuario usuario);
  void delete(Long id);
}
