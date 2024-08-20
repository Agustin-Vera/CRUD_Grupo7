package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.rol;
import com.example.ProyectoDBDGrupo7.services.rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping

public class rolController {
    private final rolService rolService;

    @Autowired
    public rolController(rolService rolService){this.rolService = rolService;}

    //Create
    @PostMapping("/create")
    @ResponseBody
    public rol createRol(@RequestBody rol rol){return rolService.createRol(rol);
    }

    //Read
    @GetMapping("/get")
    @ResponseBody
    public List<rol> getAllrol(){return rolService.getAllrol();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public rol getrolById(@PathVariable int id){return rolService.getrolById(id);}

    //Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public rol update(@RequestBody rol rol, @PathVariable int id){
        return rolService.update(rol, id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleterol(@PathVariable int id){
        rolService.deleterol(id);
    }
}
