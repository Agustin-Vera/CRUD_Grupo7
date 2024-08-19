package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.ubicacion;
import java.util.List;

public interface ubicacionRepository {

    //Create
    ubicacion create(ubicacion ubicacion);

    //Read
    List<ubicacion> AllLocations();

    List<ubicacion> LocationForId(int idusuario);

    //Update
    ubicacion Update(ubicacion ubicacion, int idubicacion);

    //Delete
    void Delete(int idusuario);

    void DeleteForLocationId(int idubicacion);

}

