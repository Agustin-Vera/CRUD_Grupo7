package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.usuarioValoraProducto;
import com.example.ProyectoDBDGrupo7.services.usuarioValoraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarioValoraProducto")
public class usuarioValoraProductoController {

    private usuarioValoraProductoService usuarioValoraProductoService;

    @Autowired
    public usuarioValoraProductoController(usuarioValoraProductoService usuarioValoraProductoService) {
        this.usuarioValoraProductoService = usuarioValoraProductoService;
    }

    // CREATE
    @PostMapping("/create")
    @ResponseBody
    public usuarioValoraProducto create(@RequestBody usuarioValoraProducto usuarioValoraProducto) {
        return usuarioValoraProductoService.crearUsuarioValoraProducto(usuarioValoraProducto);
    }

    // READ
    @GetMapping("/get")
    @ResponseBody
    public List<usuarioValoraProducto> getAllUsuarioValoraProducto() {
        return usuarioValoraProductoService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<usuarioValoraProducto> getUsuarioValoraProducto(@PathVariable int id) {
        return usuarioValoraProductoService.getUsuarioValoraProductoById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public usuarioValoraProducto updateUsuarioValoraProducto(@PathVariable int id, @RequestBody usuarioValoraProducto usuarioValoraProducto) {
        return usuarioValoraProductoService.updateUsuarioValoraProducto(usuarioValoraProducto, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteUsuarioValoraProducto(@PathVariable int id) {
        usuarioValoraProductoService.deleteUsuarioValoraProducto(id);
    }
}

