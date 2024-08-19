package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.boletadecompra;
import com.example.ProyectoDBDGrupo7.repositories.boletadecompraRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class boletadecompraService {

    private boletadecompraRepositoryImp boletadecompraRepository;

    @Autowired
    public boletadecompraService(boletadecompraRepositoryImp boletadecompraRepository)
    {this.boletadecompraRepository = boletadecompraRepository;}

    // Create

    public boletadecompra CrearBoleta(boletadecompra boletadecompra)
    {return boletadecompraRepository.create(boletadecompra);}

    // Read

    public List<boletadecompra> AllBoletas()
    {return boletadecompraRepository.GetAllBoletas();}

    public List<boletadecompra> BoletaPorId(int id)
    {return boletadecompraRepository.GetForId(id);}

    // Delete
    public void DeleteBoleta(int id)
    { boletadecompraRepository.Borrarboleta(id);}

}
