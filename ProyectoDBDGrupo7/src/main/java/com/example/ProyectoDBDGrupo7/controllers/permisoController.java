package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.permiso;
import com.example.ProyectoDBDGrupo7.services.permisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permiso")

public class permisoController {
    private final permisoService permisoService;

    @Autowired
    public permisoController(permisoService permisoService){this.permisoService = permisoService;}

    //Create
    @PostMapping("/create")
    @ResponseBody
    public permiso create(@RequestBody permiso permiso){return permisoService.create(permiso);
    }

    //Read
    @GetMapping("/get")
    @ResponseBody
    public List<permiso> getAll(){return permisoService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public permiso getById(@PathVariable int id){return permisoService.getById(id);}

    //Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public permiso update(@RequestBody permiso permiso, @PathVariable int id){
        return permisoService.update(permiso, id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id){
        permisoService.delete(id);
    }
}