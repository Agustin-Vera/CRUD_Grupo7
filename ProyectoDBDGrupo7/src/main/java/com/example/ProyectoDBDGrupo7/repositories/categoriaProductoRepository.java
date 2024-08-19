package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.categoriaProducto;
import java.util.List;

public interface categoriaProductoRepository{

    //CREATE
    categoriaProducto create(categoriaProducto categoriaProducto);

    //READ
    List<categoriaProducto> getAll();

    categoriaProducto getCategoriaProducto(int id);

    //UPDATE
    categoriaProducto update(categoriaProducto categoriaProducto, int id);

    //DELETE
    void delete(int id);
}
