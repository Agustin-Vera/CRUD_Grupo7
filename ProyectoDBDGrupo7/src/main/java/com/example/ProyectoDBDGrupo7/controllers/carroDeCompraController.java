package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.carroDeCompras;
import com.example.ProyectoDBDGrupo7.services.carroDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/carroCompra")

public class carroDeCompraController {
    private final carroDeComprasService carroDeComprasService;

    @Autowired
    public carroDeCompraController(carroDeComprasService carroDeComprasService){this.carroDeComprasService = carroDeComprasService;}

    //Create
    @PostMapping("/create")
    @ResponseBody
    public carroDeCompras create(@RequestBody carroDeCompras carroDeCompras){return carroDeComprasService.create(carroDeCompras);
    }

    //Read
    @GetMapping("/get")
    @ResponseBody
    public List<carroDeCompras> getAllcarroDeCompras(){return carroDeComprasService.getAllcarroDeCompras();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public carroDeCompras getcarroDeComprasById(@PathVariable int id){return carroDeComprasService.getcarroDeComprasById(id);}

    //Update
    @PutMapping("/update/{id}")
    @ResponseBody
    public carroDeCompras update(@RequestBody carroDeCompras carroDeCompras, @PathVariable int id){
        return carroDeComprasService.update(carroDeCompras, id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deletecarroDeCompras(@PathVariable int id){
        carroDeComprasService.deletecarroDeCompras(id);
    }
}