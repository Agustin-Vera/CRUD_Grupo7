package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.medioDePago;
import java.util.List;

public interface medioDePagoRepository {

    //CREATE
    medioDePago create(medioDePago medioDePago);

    //READ
    List<medioDePago> getAll();

    medioDePago getMedioDePago(int id);

    //UPDATE
    medioDePago update(medioDePago medioDePago, int id);

    //DELETE
    void deleteMedioDePago(int id);
}