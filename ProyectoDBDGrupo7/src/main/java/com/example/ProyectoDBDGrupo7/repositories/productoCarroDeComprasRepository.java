package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.productoCarroDeCompras;

import java.util.List;

public interface productoCarroDeComprasRepository {
    //CREATE
    productoCarroDeCompras create(productoCarroDeCompras productoCarroDeCompras);

    //READ
    List<productoCarroDeCompras> getAll();

    productoCarroDeCompras getById(int id);

    //UPDATE
    productoCarroDeCompras update(productoCarroDeCompras productoCarroDeCompras, int id);

    //DELETE
    void delete(int id);
}
