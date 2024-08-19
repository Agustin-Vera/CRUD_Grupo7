package com.example.ProyectoDBDGrupo7.repositories;
import com.example.ProyectoDBDGrupo7.models.boletadecompra;
import java.util.List;

public interface boletadecompraRepository {

    //Create
    boletadecompra create(boletadecompra boletadecompra);

    //Read
    List<boletadecompra> GetAllBoletas();

    List<boletadecompra> GetForId(int idboletadecompra);

    //Delete
    void Borrarboleta(int idboletadecompra);
}
