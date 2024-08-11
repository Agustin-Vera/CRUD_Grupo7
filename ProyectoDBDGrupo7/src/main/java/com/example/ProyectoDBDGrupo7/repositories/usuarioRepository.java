package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.usuario;
import java.util.List;

public interface usuarioRepository {

    // CREATE
    usuario create(usuario usuario);

    // READ
    List<usuario> getAllUsers();

    List<usuario> getUser(int id);

    // UPDATE
    usuario update(usuario usuario, int id);
    // DELETE
    void borrarUsuario(int id);
}
