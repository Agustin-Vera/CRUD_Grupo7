package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.rolPermiso;
import com.example.ProyectoDBDGrupo7.repositories.rolPermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rolPermisoService {
    private rolPermisoRepository rolPermisoRepository;

    @Autowired
    public rolPermisoService(rolPermisoRepository rolPermisoRepository){this.rolPermisoRepository = rolPermisoRepository;}

    //CREATE
    public rolPermiso create(rolPermiso rolPermiso){return rolPermisoRepository.create(rolPermiso);}

    //READ
    public List<rolPermiso> getAll() {return rolPermisoRepository.getAll();}

    public rolPermiso getById(int id){return rolPermisoRepository.getById(id);}

    //UPDATE
    public rolPermiso update(rolPermiso rolPermiso, int id){return rolPermisoRepository.update(rolPermiso,id);}

    //DELETE
    public void delete(int id){rolPermisoRepository.delete(id);}
}
