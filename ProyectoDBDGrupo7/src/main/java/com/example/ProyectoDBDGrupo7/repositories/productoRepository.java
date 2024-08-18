package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.producto;
import java.util.List;

public interface productoRepository{

    //CREATE
    producto create(producto producto);

    //READ
    List<producto> getAll();

    producto getProducto(int id);

    //UPDATE
    producto update(producto producto, int id);

    //DELETE
    void delete(int id);
}
