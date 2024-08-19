package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.categoriaProducto;
import com.example.ProyectoDBDGrupo7.repositories.categoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class categoriaProductoService{
    private categoriaProductoRepository categoriaProductoRepository;

    @Autowired
    public categoriaProductoService(categoriaProductoRepository categoriaProductoRepository) {
        this.categoriaProductoRepository = categoriaProductoRepository;
    }

    //CREATE
    public categoriaProducto crearCategoriaProducto(categoriaProducto categoriaProducto){
        return categoriaProductoRepository.create(categoriaProducto);
    }

    //READ
    public List<categoriaProducto> getAllCategoriaProducto(){
        return categoriaProductoRepository.getAll();
    }

    public categoriaProducto getCategoriaProductoById(int id){
        return categoriaProductoRepository.getCategoriaProducto(id);
    }

    //UPDATE
    public categoriaProducto updateCategoriaProducto(categoriaProducto categoriaProducto, int id){
        return categoriaProductoRepository.update(categoriaProducto,id);
    }

    //DELETE
    public void deleteCategoriaProducto(int id){
        categoriaProductoRepository.delete(id);
    }
}
