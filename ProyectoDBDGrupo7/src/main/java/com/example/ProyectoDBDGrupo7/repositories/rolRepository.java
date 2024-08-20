package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.rol;

import java.util.List;

public interface rolRepository {

    //Create
    rol createRol(rol rol);

    //Read
    List<rol> getAllrol();

    rol getrolById(int id);

    //Update
    rol update(rol rol, int id);

    //Delete
    void deleterol(int id);

}
