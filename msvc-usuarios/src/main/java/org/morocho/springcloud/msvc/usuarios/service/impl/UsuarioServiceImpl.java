package org.morocho.springcloud.msvc.usuarios.service.impl;

import org.morocho.springcloud.msvc.usuarios.models.entitiy.Usuario;
import org.morocho.springcloud.msvc.usuarios.repository.IUsuarioRepo;
import org.morocho.springcloud.msvc.usuarios.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

  @Autowired
  private IUsuarioRepo repo;

  @Override
  @Transactional(readOnly = true)
  public List<Usuario> findAll() {
    return repo.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Usuario> findByIdUsuario(Long id) {
    return repo.findById(id);
  }

  @Override
  @Transactional
  public Usuario saveUsuario(Usuario usuario) {
    return repo.save(usuario);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    repo.deleteById(id);
  }
}
