package com.example.crud_usuarios.servicios;

import com.example.crud_usuarios.entidades.Usuario;
import com.example.crud_usuarios.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> guardarUsuarios(List<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios); // Guarda y retorna la lista de usuarios
    }

    public Usuario guardarUsuario(Usuario usuario) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        return guardarUsuarios(usuarios).get(0); // Llama al método guardarUsuarios y devuelve el primer usuario
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
