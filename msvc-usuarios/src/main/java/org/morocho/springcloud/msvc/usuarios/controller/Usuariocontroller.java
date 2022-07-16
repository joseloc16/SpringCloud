package org.morocho.springcloud.msvc.usuarios.controller;

import org.morocho.springcloud.msvc.usuarios.models.entitiy.Usuario;
import org.morocho.springcloud.msvc.usuarios.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Usuariocontroller {

  @Autowired
  private IUsuarioService service;

  @GetMapping
  public ResponseEntity<List<Usuario>> listUsers() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getUser(@PathVariable Long id) {
    Optional<Usuario> usuarioOptional = service.findByIdUsuario(id);
    return usuarioOptional.map(ResponseEntity::ok)
        .orElseGet(
            () -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
    return new ResponseEntity<>(
        service.saveUsuario(usuario), HttpStatus.CREATED
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> updateUser(
      @RequestBody Usuario usuario, @PathVariable Long id) {
    Optional<Usuario> usuarioOptional = service.findByIdUsuario(id);

    if (usuarioOptional.isPresent()) {
      Usuario usuarioDb = usuarioOptional.get();
        usuarioDb.setNombre(usuario.getNombre());
        usuarioDb.setEmail(usuario.getEmail());
        usuarioDb.setPassword(usuario.getPassword());
        service.saveUsuario(usuarioDb);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeUser(@PathVariable Long id) {
    Optional<Usuario> usuario = service.findByIdUsuario(id);
    if(usuario.isPresent()) {
      service.delete(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
