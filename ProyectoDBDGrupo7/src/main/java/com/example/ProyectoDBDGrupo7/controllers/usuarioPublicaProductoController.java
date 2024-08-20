package com.example.ProyectoDBDGrupo7.controllers;


import com.example.ProyectoDBDGrupo7.models.usuarioPublicaProducto;
import com.example.ProyectoDBDGrupo7.services.usuarioPublicaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarioPublicaProducto")
public class usuarioPublicaProductoController {

    private usuarioPublicaProductoService usuarioPublicaProductoService;

    @Autowired
    public usuarioPublicaProductoController(usuarioPublicaProductoService usuarioPublicaProductoService) {
        this.usuarioPublicaProductoService = usuarioPublicaProductoService;
    }

    // CREATE
    @PostMapping("/create")
    @ResponseBody
    public usuarioPublicaProducto create(@RequestBody usuarioPublicaProducto usuarioPublicaProducto) {
        return usuarioPublicaProductoService.crearUsuarioPublicaProducto(usuarioPublicaProducto);
    }

    // READ
    @GetMapping("/get")
    @ResponseBody
    public List<usuarioPublicaProducto> getAllUsuarioPublicaProducto() {
        return usuarioPublicaProductoService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<usuarioPublicaProducto> getUsuarioPublicaProductoById(@PathVariable int id) {
        return usuarioPublicaProductoService.getUsuarioPublicaProductoById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public usuarioPublicaProducto updateusuarioPublicaProducto(@PathVariable int id, @RequestBody usuarioPublicaProducto usuarioPublicaProducto) {
        return usuarioPublicaProductoService.updateUsuarioPublicaProducto(usuarioPublicaProducto, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        usuarioPublicaProductoService.deleteUsuarioPublicaProducto(id);
    }


}

