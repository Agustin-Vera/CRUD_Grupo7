package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.productoCarroDeCompras;
import com.example.ProyectoDBDGrupo7.repositories.productoCarroDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productoCarroDeComprasService {
    private productoCarroDeComprasRepository productoCarroDeComprasRepository;

    @Autowired
    public productoCarroDeComprasService(productoCarroDeComprasRepository productoCarroDeComprasRepository){this.productoCarroDeComprasRepository = productoCarroDeComprasRepository;}

    //CREATE
    public productoCarroDeCompras create(productoCarroDeCompras permiso){return productoCarroDeComprasRepository.create(permiso);}

    //READ
    public List<productoCarroDeCompras> getAll() {return productoCarroDeComprasRepository.getAll();}

    public productoCarroDeCompras getById(int id){return productoCarroDeComprasRepository.getById(id);}

    //UPDATE
    public productoCarroDeCompras update(productoCarroDeCompras permiso, int id){return productoCarroDeComprasRepository.update(permiso,id);}

    //DELETE
    public void delete(int id){productoCarroDeComprasRepository.delete(id);}
}
