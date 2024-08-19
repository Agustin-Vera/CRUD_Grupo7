package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.ubicacion;
import com.example.ProyectoDBDGrupo7.repositories.ubicacionRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ubicacionService {

    private ubicacionRepositoryImp ubicacionRepository;

    @Autowired
    public ubicacionService(ubicacionRepositoryImp ubicacionRepository) {this.ubicacionRepository = ubicacionRepository;}

    // Create
    public ubicacion crearUbicacion(ubicacion ubicacion) {return ubicacionRepository.create(ubicacion);}

    // Read
    public List<ubicacion> GetAllLocations() {return ubicacionRepository.AllLocations();}

    public List<ubicacion> GetLocationId(int idusuario)
    {return ubicacionRepository.LocationForId(idusuario);}

    // Update

    public ubicacion update(ubicacion ubicacion, int idubicacion)
    {return ubicacionRepository.Update(ubicacion,idubicacion);}

    // Delete
    public void DeleteAllForUser(int idusuario)
    { ubicacionRepository.Delete(idusuario);}

    public void deleteForLocationId(int idubicacion)
    { ubicacionRepository.DeleteForLocationId(idubicacion);}

}
