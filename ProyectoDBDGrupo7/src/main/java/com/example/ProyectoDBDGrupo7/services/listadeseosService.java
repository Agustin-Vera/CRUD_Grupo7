package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.listadeseos;
import com.example.ProyectoDBDGrupo7.repositories.listadeseosRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class listadeseosService {

    private listadeseosRepositoryImp listadeseosRepository;

    @Autowired
    public listadeseosService(listadeseosRepositoryImp listadeseosRepository) {this.listadeseosRepository = listadeseosRepository;}

    // Create
    public listadeseos CrearListaDeseos(listadeseos listadeseos)
    {return listadeseosRepository.create(listadeseos);}

    // Read
    public List<listadeseos> GetAllLists()
    {return listadeseosRepository.getAllList();}

    public listadeseos GetListById(int id)
    {return listadeseosRepository.GetListForId(id);}

    // Delete
    public void delete(int id)
    { listadeseosRepository.Delete(id);}

}
