package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.listaDeseosProducto;
import com.example.ProyectoDBDGrupo7.repositories.listaDeseosProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class listaDeseosProductoService {
    private listaDeseosProductoRepository listaDeseosProductoRepository;

    @Autowired
    public listaDeseosProductoService(listaDeseosProductoRepository listaDeseosProductoRepository) {
        this.listaDeseosProductoRepository = listaDeseosProductoRepository;
    }

    //CREATE
    public listaDeseosProducto crearListaDeseosProducto(listaDeseosProducto listaDeseosProducto) {
        return listaDeseosProductoRepository.create(listaDeseosProducto);
    }

    //READ
    public List<listaDeseosProducto> getAllListaDeseosProducto() {
        return listaDeseosProductoRepository.getAll();
    }

    public List<listaDeseosProducto> getListaDeseosProductoById(int id){
        return listaDeseosProductoRepository.getListaDeseosProducto(id);
    }

    //UPDATE
    public listaDeseosProducto updateListaDeseosProducto(listaDeseosProducto listaDeseosProducto, int id){
        return listaDeseosProductoRepository.update(listaDeseosProducto, id);
    }

    //DELETE
    public void deleteListaDeseosProducto(int id){
        listaDeseosProductoRepository.delete(id);
    }
}
