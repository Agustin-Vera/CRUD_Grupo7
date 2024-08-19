package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.listaDeseosProducto;
import java.util.List;

public interface listaDeseosProductoRepository {

    //CREATE
    listaDeseosProducto create(listaDeseosProducto listaDeseosProducto);

    //READ
    List<listaDeseosProducto> getAll();

    List<listaDeseosProducto> getListaDeseosProducto(int id);

    //UPDATE
    listaDeseosProducto update(listaDeseosProducto listaDeseosProducto, int id);

    //DELETE
    void delete(int id);
}




