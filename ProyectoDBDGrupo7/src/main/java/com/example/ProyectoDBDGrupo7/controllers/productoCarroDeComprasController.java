package com.example.ProyectoDBDGrupo7.controllers;


import com.example.ProyectoDBDGrupo7.models.productoCarroDeCompras;
import com.example.ProyectoDBDGrupo7.services.productoCarroDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping

public class productoCarroDeComprasController {
    private final productoCarroDeComprasService productoCarroDeComprasService;

    @Autowired
    public productoCarroDeComprasController(productoCarroDeComprasService productoCarroDeComprasService){this.productoCarroDeComprasService = productoCarroDeComprasService;}

    //Create
    @PostMapping("/create")
    @ResponseBody
    public productoCarroDeCompras create(@RequestBody productoCarroDeCompras productoCarroDeCompras){return productoCarroDeComprasService.create(productoCarroDeCompras);
    }

    //Read
    @GetMapping("/get")
    @ResponseBody
    public List<productoCarroDeCompras> getAll(){return productoCarroDeComprasService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public productoCarroDeCompras getById(@PathVariable int id){return productoCarroDeComprasService.getById(id);}

    //Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public productoCarroDeCompras update(@RequestBody productoCarroDeCompras productoCarroDeCompras, @PathVariable int id){
        return productoCarroDeComprasService.update(productoCarroDeCompras, id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id){
        productoCarroDeComprasService.delete(id);
    }
}