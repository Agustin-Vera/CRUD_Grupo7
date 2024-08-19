package com.example.ProyectoDBDGrupo7.controllers;


import com.example.ProyectoDBDGrupo7.models.categoriaProducto;
import com.example.ProyectoDBDGrupo7.services.categoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categoriaProducto")
public class categoriaProductoController {
    private final categoriaProductoService categoriaProductoService;

    @Autowired
    public categoriaProductoController(categoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    //CREATE
    @PostMapping("/create")
    @ResponseBody
    public categoriaProducto create(@RequestBody categoriaProducto categoriaProducto) {
        System.out.println("Se ha creado la categoria del producto:"+"\n"+categoriaProducto.toString());
        return categoriaProductoService.crearCategoriaProducto(categoriaProducto);
    }

    //READ
    @GetMapping("/get")
    @ResponseBody
    public List<categoriaProducto> getAllCategoriaProducto() {
        return categoriaProductoService.getAllCategoriaProducto();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public categoriaProducto getCategoriaProducto(@PathVariable int id) {
        return categoriaProductoService.getCategoriaProductoById(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public categoriaProducto updateCategoriaProducto(@RequestBody categoriaProducto categoriaProducto, @PathVariable int id) {
        return categoriaProductoService.updateCategoriaProducto(categoriaProducto, id);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteCategoriaProducto(@PathVariable int id) {
        categoriaProductoService.deleteCategoriaProducto(id);
    }
}
