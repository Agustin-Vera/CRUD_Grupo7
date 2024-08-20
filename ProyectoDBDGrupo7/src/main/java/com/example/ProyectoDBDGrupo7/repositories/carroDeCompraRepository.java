package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.carroDeCompras;
import java.util.List;

public interface carroDeCompraRepository {

    //Create
    carroDeCompras create(carroDeCompras carroDeCompras);

    //Read
    List<carroDeCompras> getAllcarroDeCompras();

    carroDeCompras getcarroDeComprasById(int id);

    //Update
    carroDeCompras update(carroDeCompras carroDeCompras, int id);

    //Delete
    void deletecarroDeCompras(int id);

}
