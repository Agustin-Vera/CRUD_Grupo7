package com.example.ProyectoDBDGrupo7.repositories;

import java.util.List;
import com.example.ProyectoDBDGrupo7.models.listadeseos;

public interface listadeseosRepository {

    // Create
    listadeseos create(listadeseos listadeseos);

    // Read
    List<listadeseos> getAllList();

    listadeseos GetListForId(int IdUsuario);

    // Delete
    void Delete(int IdUsuario);
}
