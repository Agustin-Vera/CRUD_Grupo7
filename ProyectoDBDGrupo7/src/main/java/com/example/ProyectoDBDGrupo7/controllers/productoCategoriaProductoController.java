package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.productoCategoriaProducto;
import com.example.ProyectoDBDGrupo7.services.productoCategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productoCategoriaProducto")
public class productoCategoriaProductoController {
    private final productoCategoriaProductoService productoCategoriaProductoService;

    @Autowired
    public productoCategoriaProductoController(productoCategoriaProductoService productoCategoriaProductoService) {
        this.productoCategoriaProductoService = productoCategoriaProductoService;
    }

    //CREATE
    @PostMapping("/create")
    @ResponseBody
    public productoCategoriaProducto create(@RequestBody productoCategoriaProducto productoCategoriaProducto) {
        System.out.println("Se ha creado la unión entre el producto y su categoria:"+"\n"+productoCategoriaProducto.toString());
        return productoCategoriaProductoService.crearProductoCategoriaProducto(productoCategoriaProducto);
    }

    //READ
    @GetMapping("/get")
    @ResponseBody
    public List<productoCategoriaProducto> getAllProductoCategoriaProducto() {
        return productoCategoriaProductoService.getAllProductoCategoriaProducto();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<productoCategoriaProducto> getProductoCategoriaProducto(@PathVariable int id) {
        return productoCategoriaProductoService.getProductoCategoriaProducto(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public productoCategoriaProducto updateProductoCategoriaProducto(@RequestBody productoCategoriaProducto productoCategoriaProducto, @PathVariable int id) {
        return productoCategoriaProductoService.updateProductoCategoriaProducto(productoCategoriaProducto, id);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteProductoCategoriaProducto(@PathVariable int id) {
        productoCategoriaProductoService.deleteProductoCategoriaProducto(id);
    }
}
