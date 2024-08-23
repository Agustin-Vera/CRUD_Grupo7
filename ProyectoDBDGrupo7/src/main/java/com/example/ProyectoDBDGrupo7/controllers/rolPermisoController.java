package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.rolPermiso;
import com.example.ProyectoDBDGrupo7.services.rolPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rolPermiso")

public class rolPermisoController {
    private final rolPermisoService rolPermisoService;

    @Autowired
    public rolPermisoController(rolPermisoService rolPermisoService){this.rolPermisoService = rolPermisoService;}

    //Create
    @PostMapping("/create")
    @ResponseBody
    public rolPermiso create(@RequestBody rolPermiso rolPermiso){return rolPermisoService.create(rolPermiso);
    }

    //Read
    @GetMapping("/get")
    @ResponseBody
    public List<rolPermiso> getAll(){return rolPermisoService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public rolPermiso getById(@PathVariable int id){return rolPermisoService.getById(id);}

    //Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public rolPermiso update(@RequestBody rolPermiso rolPermiso, @PathVariable int id){
        return rolPermisoService.update(rolPermiso, id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id){
        rolPermisoService.delete(id);
    }
}