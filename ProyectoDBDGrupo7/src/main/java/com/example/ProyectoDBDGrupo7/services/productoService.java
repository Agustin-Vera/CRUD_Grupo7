package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.producto;
import com.example.ProyectoDBDGrupo7.repositories.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//import java.util.Optional;

@Service
public class productoService{
    private productoRepository productoRepository;

    @Autowired
    public productoService(productoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //CREATE
    public producto crearProducto(producto producto){
        return productoRepository.create(producto);
    }

    //READ
    public List<producto> getAllProductos(){
        return productoRepository.getAll();
    }

    public producto getProductoById(int id){
        return productoRepository.getProducto(id);
    }

    //UPDATE
    public producto updateProducto(producto producto, int id){
        return productoRepository.update(producto, id);
    }

    //DELETE
    public void deleteProducto(int id){
        productoRepository.delete(id);
    }
}
