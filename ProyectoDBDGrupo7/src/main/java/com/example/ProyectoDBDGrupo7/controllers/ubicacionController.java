package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.ubicacion;
import com.example.ProyectoDBDGrupo7.services.ubicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ubicacion")
public class ubicacionController {
    private final ubicacionService ubicacionService;

    @Autowired
    public ubicacionController(ubicacionService ubicacionService)
    {this.ubicacionService = ubicacionService;}

    // Create
    @PostMapping("/create")
    @ResponseBody
    public ubicacion create(@RequestBody ubicacion ubicacion)
    {return ubicacionService.crearUbicacion(ubicacion);}

    // Read
    @GetMapping("/get")
    @ResponseBody
    public List<ubicacion> AllLocations() {
        return ubicacionService.GetAllLocations();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<ubicacion> LocationsForUser(@PathVariable int id) {
        return ubicacionService.GetLocationId(id);
    }

    // Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public ubicacion UpdateLocation(@PathVariable int id, @RequestBody ubicacion ubicacion) {
        return ubicacionService.update(ubicacion, id);
    }

    // Delete
    @DeleteMapping("/delete/user{id}")
    @ResponseBody
    public void DeleteUserLocations(@PathVariable int id)
    { ubicacionService.DeleteAllForUser(id);}

    @DeleteMapping("/delete/location{id}")
    @ResponseBody
    public void DeleteLocation(@PathVariable int id)
    { ubicacionService.deleteForLocationId(id);}

}
