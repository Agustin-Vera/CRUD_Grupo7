package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.permiso;
import com.example.ProyectoDBDGrupo7.repositories.permisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class permisoService {
    private permisoRepository permisoRepository;

    @Autowired
    public permisoService(permisoRepository permisoRepository){this.permisoRepository = permisoRepository;}

    //CREATE
    public permiso create(permiso permiso){return permisoRepository.create(permiso);}

    //READ
    public List<permiso> getAll() {return permisoRepository.getAll();}

    public permiso getById(int id){return permisoRepository.getById(id);}

    //UPDATE
    public permiso update(permiso permiso, int id){return permisoRepository.update(permiso,id);}

    //DELETE
    public void delete(int id){permisoRepository.delete(id);}
}
