package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.medioDePago;
import com.example.ProyectoDBDGrupo7.repositories.medioDePagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class medioDePagoService {
    private medioDePagoRepository medioDePagoRepository;

    @Autowired
    public medioDePagoService(medioDePagoRepository medioDePagoRepository){this.medioDePagoRepository = medioDePagoRepository;}

    //CREATE
    public medioDePago crearMedioDePago(medioDePago medioDePago){return medioDePagoRepository.create(medioDePago);}

    //READ
    public List<medioDePago> getAll() {return medioDePagoRepository.getAll();}

    public medioDePago getMedioDePagoById(int id){return medioDePagoRepository.getMedioDePago(id);}

    //UPDATE
    public medioDePago updateMedioDePago(medioDePago medioDePago, int id){return medioDePagoRepository.update(medioDePago,id);}

    //DELETE
    public void deleteMedioDePago(int id){medioDePagoRepository.deleteMedioDePago(id);}

}