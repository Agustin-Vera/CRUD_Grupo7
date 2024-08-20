package com.example.ProyectoDBDGrupo7.controllers;


import com.example.ProyectoDBDGrupo7.models.medioDePago;
import com.example.ProyectoDBDGrupo7.services.medioDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping

public class medioDePagoController {
    private final medioDePagoService medioDePagoService;

    @Autowired
    public medioDePagoController(medioDePagoService medioDePagoService){this.medioDePagoService = medioDePagoService;}

    //Create
    @PostMapping("/create")
    @ResponseBody
    public medioDePago crearMedioDePago(@RequestBody medioDePago medioDePago){return medioDePagoService.crearMedioDePago(medioDePago);
    }

    //Read
    @GetMapping("/get")
    @ResponseBody
    public List<medioDePago> getAll(){return medioDePagoService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public medioDePago getMedioDePagoById(@PathVariable int id){return medioDePagoService.getMedioDePagoById(id);}

    //Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public medioDePago updateMedioDePago(@RequestBody medioDePago medioDePago, @PathVariable int id){
        return medioDePagoService.updateMedioDePago(medioDePago, id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteMedioDePago(@PathVariable int id){
        medioDePagoService.deleteMedioDePago(id);
    }
}