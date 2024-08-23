package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.usuario;
import com.example.ProyectoDBDGrupo7.repositories.usuarioRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * @Service: Marca la clase como un servicio de Spring, indicando que contiene la lógica de negocio y será gestionada
 *   por el contenedor de Spring. Esta anotación también facilita la inyección de dependencias
 * */
@Service
public class usuarioService {

    private usuarioRepositoryImp usuarioRepository;

    //@Autowired: Indica a Spring que debe inyectar una instancia de usuarioRepositoryImp en esta clase
    @Autowired
    public usuarioService(usuarioRepositoryImp usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // CREATE
    public usuario crearUsuario(usuario usuario) {
        return usuarioRepository.create(usuario);
    }

    // READ
    public List<usuario> getAll() {
        return usuarioRepository.getAllUsers();
    }

    public List<usuario> getUserById(int id) {
        return usuarioRepository.getUser(id);
    }

    // UPDATE
    public usuario updateUser(usuario usuario, int id) {
        return usuarioRepository.update(usuario, id);
    }

    // DELETE
    public void deleteUser(int id) {
        usuarioRepository.borrarUsuario(id);
    }

    //LOGIN
    public usuario loginUser(String correo, String contraseña) {
        return usuarioRepository.loginUsuario(correo,contraseña);
    }
}
