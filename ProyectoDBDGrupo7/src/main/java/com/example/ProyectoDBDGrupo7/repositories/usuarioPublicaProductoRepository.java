package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.usuarioPublicaProducto;

import java.util.List;

public interface usuarioPublicaProductoRepository {

    // CREATE
    usuarioPublicaProducto create(usuarioPublicaProducto usuarioPublicaProducto);

    // READ
    List<usuarioPublicaProducto> getAllUsuarioPublicaProducto();

    List<usuarioPublicaProducto> getUsuarioPublicaProducto(int id);

    // UPDATE
    usuarioPublicaProducto update(usuarioPublicaProducto usuarioPublicaProducto, int id);

    // DELETE
    void borrarUsuarioPublicaProducto(int id);
}
