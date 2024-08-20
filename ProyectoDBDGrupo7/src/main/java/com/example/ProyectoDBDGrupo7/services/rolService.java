package com.example.ProyectoDBDGrupo7.services;


import com.example.ProyectoDBDGrupo7.models.rol;
import com.example.ProyectoDBDGrupo7.repositories.rolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rolService {
    private rolRepository rolRepository;

    @Autowired
    public rolService(rolRepository rolRepository){this.rolRepository = rolRepository;}

    //CREATE
    public rol createRol(rol rol){return rolRepository.createRol(rol);}

    //READ
    public List<rol> getAllrol() {return rolRepository.getAllrol();}

    public rol getrolById(int id){return rolRepository.getrolById(id);}

    //UPDATE
    public rol update(rol rol, int id){return rolRepository.update(rol,id);}

    //DELETE
    public void deleterol(int id){rolRepository.deleterol(id);}

}

