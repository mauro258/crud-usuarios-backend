package com.example.crud_usuarios.controladores;

import com.example.crud_usuarios.entidades.Usuario;
import com.example.crud_usuarios.servicios.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections; // Esta es la correcta
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<List<Usuario>> crearUsuarios(@RequestBody List<Usuario> usuarios) {
        List<Usuario> nuevosUsuarios = usuarioService.guardarUsuarios(usuarios);
        return new ResponseEntity<>(nuevosUsuarios, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> usuario = usuarioService.obtenerPorId(id);
        if (usuario.isPresent()) {
            Usuario _usuario = usuario.get();
            _usuario.setNombre(usuarioActualizado.getNombre());
            _usuario.setApellido(usuarioActualizado.getApellido());
            _usuario.setEmail(usuarioActualizado.getEmail());
            _usuario.setTelefono(usuarioActualizado.getTelefono());
            _usuario.setDireccion(usuarioActualizado.getDireccion());
            List<Usuario> usuariosActualizados = usuarioService.guardarUsuarios(Collections.singletonList(_usuario));
            return ResponseEntity.ok(usuariosActualizados.get(0)); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (usuarioService.obtenerPorId(id).isPresent()) {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
