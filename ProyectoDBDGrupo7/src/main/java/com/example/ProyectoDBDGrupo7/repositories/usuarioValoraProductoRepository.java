package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.usuarioValoraProducto;

import java.util.List;

public interface usuarioValoraProductoRepository {

    // CREATE
    usuarioValoraProducto create(usuarioValoraProducto usuarioValoraProducto);

    // READ
    List<usuarioValoraProducto> getAllUsuarioValoraProducto();

    List<usuarioValoraProducto> getUsuarioValoraProducto(int id);

    // UPDATE
    usuarioValoraProducto update(usuarioValoraProducto usuarioValoraProducto, int id);

    // UPDATE
    void borrarUsuarioValoraProducto(int id);
}

