package com.example.ProyectoDBDGrupo7.repositories;


import com.example.ProyectoDBDGrupo7.models.rolPermiso;
import java.util.List;

public interface rolPermisoRepository {
    //CREATE
    rolPermiso create(rolPermiso rolPermiso);

    //READ
    List<rolPermiso> getAll();

    rolPermiso getById(int id);

    //UPDATE
    rolPermiso update(rolPermiso rolPermiso, int id);

    //DELETE
    void delete(int id);
}
