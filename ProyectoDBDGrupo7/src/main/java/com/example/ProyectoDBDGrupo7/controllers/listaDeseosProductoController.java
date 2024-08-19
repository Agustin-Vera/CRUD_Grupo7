package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.listaDeseosProducto;
import com.example.ProyectoDBDGrupo7.services.listaDeseosProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/listaDeseosProducto")
public class listaDeseosProductoController {
    private final listaDeseosProductoService listaDeseosProductoService;

    @Autowired
    public listaDeseosProductoController(listaDeseosProductoService listaDeseosProductoService) {
        this.listaDeseosProductoService = listaDeseosProductoService;
    }

    //CREATE
    @PostMapping("/create")
    @ResponseBody
    public listaDeseosProducto create(@RequestBody listaDeseosProducto listaDeseosProducto) {
        System.out.println("Se ha creado la unión entre el producto y su lista de deseos:"+"\n"+listaDeseosProducto.toString());
        return listaDeseosProductoService.crearListaDeseosProducto(listaDeseosProducto);
    }

    //READ
    @GetMapping("/get")
    @ResponseBody
    public List<listaDeseosProducto> getAllListaDeseosProducto() {
        return listaDeseosProductoService.getAllListaDeseosProducto();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<listaDeseosProducto> getListaDeseosProducto(@PathVariable int id) {
        return listaDeseosProductoService.getListaDeseosProductoById(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public listaDeseosProducto updateCategoriaProducto(@RequestBody listaDeseosProducto listaDeseosProducto, @PathVariable int id) {
        return listaDeseosProductoService.updateListaDeseosProducto(listaDeseosProducto, id);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteListaDeseosProducto(@PathVariable int id) {
        listaDeseosProductoService.deleteListaDeseosProducto(id);
    }
}
