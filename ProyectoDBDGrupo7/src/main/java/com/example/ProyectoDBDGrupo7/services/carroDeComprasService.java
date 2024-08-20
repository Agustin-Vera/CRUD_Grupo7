package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.carroDeCompras;
import com.example.ProyectoDBDGrupo7.repositories.carroDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class carroDeComprasService {
    private carroDeCompraRepository carroDeCompraRepository;

    @Autowired
    public carroDeComprasService(carroDeCompraRepository carroDeCompraRepository){this.carroDeCompraRepository = carroDeCompraRepository;}

    //CREATE
    public carroDeCompras create(carroDeCompras carroDeCompras){return carroDeCompraRepository.create(carroDeCompras);}

    //READ
    public List<carroDeCompras> getAllcarroDeCompras() {return carroDeCompraRepository.getAllcarroDeCompras();}

    public carroDeCompras getcarroDeComprasById(int id){return carroDeCompraRepository.getcarroDeComprasById(id);}

    //UPDATE
    public carroDeCompras update(carroDeCompras carroDeCompras, int id){return carroDeCompraRepository.update(carroDeCompras,id);}

    //DELETE
    public void deletecarroDeCompras(int id){carroDeCompraRepository.deletecarroDeCompras(id);}

}
