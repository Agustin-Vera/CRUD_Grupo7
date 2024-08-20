package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.permiso;
import java.util.List;

public interface permisoRepository {
    //CREATE
    permiso create(permiso permiso);

    //READ
    List<permiso> getAll();

    permiso getById(int id);

    //UPDATE
    permiso update(permiso permiso, int id);

    //DELETE
    void delete(int id);
}
