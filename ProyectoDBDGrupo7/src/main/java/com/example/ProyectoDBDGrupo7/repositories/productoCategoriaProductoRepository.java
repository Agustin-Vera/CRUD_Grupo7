package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.productoCategoriaProducto;
import java.util.List;

public interface productoCategoriaProductoRepository {

    //CREATE
    productoCategoriaProducto create(productoCategoriaProducto productoCategoriaProducto);

    //READ
    List<productoCategoriaProducto> getAll();

    List<productoCategoriaProducto> getProductoCategoriaProducto(int id);

    //UPDATE
    productoCategoriaProducto update(productoCategoriaProducto productoCategoriaProducto, int id);

    //DELETE
    void delete(int id);
}
