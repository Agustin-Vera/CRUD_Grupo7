package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.productoCategoriaProducto;
import com.example.ProyectoDBDGrupo7.repositories.productoCategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class productoCategoriaProductoService {
    private productoCategoriaProductoRepository productoCategoriaProductoRepository;

    @Autowired
    public productoCategoriaProductoService(productoCategoriaProductoRepository productoCategoriaProductoRepository) {
        this.productoCategoriaProductoRepository = productoCategoriaProductoRepository;
    }

    //CREATE
    public productoCategoriaProducto crearProductoCategoriaProducto(productoCategoriaProducto productoCategoriaProducto) {
        return productoCategoriaProductoRepository.create(productoCategoriaProducto);
    }

    //READ
    public List<productoCategoriaProducto> getAllProductoCategoriaProducto() {
        return productoCategoriaProductoRepository.getAll();
    }

    public List<productoCategoriaProducto> getProductoCategoriaProducto(int id) {
        return productoCategoriaProductoRepository.getProductoCategoriaProducto(id);
    }

    //UPDATE
    public productoCategoriaProducto updateProductoCategoriaProducto(productoCategoriaProducto productoCategoriaProducto, int id) {
        return productoCategoriaProductoRepository.update(productoCategoriaProducto,id);
    }

    //DELETE
    public void deleteProductoCategoriaProducto(int id) {
        productoCategoriaProductoRepository.delete(id);
    }
}
