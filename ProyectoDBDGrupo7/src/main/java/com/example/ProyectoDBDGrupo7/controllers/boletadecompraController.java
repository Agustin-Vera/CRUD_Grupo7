package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.boletadecompra;
import com.example.ProyectoDBDGrupo7.services.boletadecompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/boleta")

public class boletadecompraController {
    private final boletadecompraService boletadecompraService;

    @Autowired
    public boletadecompraController( boletadecompraService boletadecompraService)
    {this.boletadecompraService = boletadecompraService; }

    //Create
    @PostMapping("/create")
    @ResponseBody
    public boletadecompra crearboleta(@RequestBody boletadecompra boletadecompra)
    {return boletadecompraService.CrearBoleta(boletadecompra); }

    // Read
    @GetMapping("/get")
    @ResponseBody
    public List<boletadecompra> GetAll()
    {return boletadecompraService.AllBoletas();}

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<boletadecompra> GetBoletaUser(@PathVariable int id)
    {return boletadecompraService.BoletaPorId(id);}

    // Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteboleta(@PathVariable int id)
    { boletadecompraService.DeleteBoleta(id); }

}
