package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.boletadecompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class boletadecompraRepositoryImp implements boletadecompraRepository{

    private Sql2o sql2o;

    @Autowired
    public boletadecompraRepositoryImp(Sql2o sql2o)
    {this.sql2o = sql2o;}

    // Create
    @Override
    public boletadecompra create(boletadecompra boletadecompra) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO BOLETA_DE_COMPRA(FechaBoleta, MontoBoleta, IdCarro, IdMedioPago)" +
                    "VALUES (: FechaBoleta, :MontoBoleta, :IdCarro, :IdMedioPago)";
            long idboleta = con.createQuery(sql, true)
                    .addParameter("FechaBoleta", boletadecompra.getFechaBoleta())
                    .addParameter("MontoBoleta", boletadecompra.getMontoBoleta())
                    .addParameter("IdCarro", boletadecompra.getIdCarro())
                    .addParameter("IdMedioPago", boletadecompra.getIdMedioPago())
                    .executeUpdate()
                    .getKey(Long.class);
            boletadecompra.setIdBoletadeCompra(idboleta);
            return boletadecompra;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Read
    // Obtiene la lista completa de todas las boletas registradas
    @Override
    public List<boletadecompra> GetAllBoletas(){
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM BOLETA_DE_COMPRA";
            return con.createQuery(sql).executeAndFetch(boletadecompra.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<boletadecompra> GetForId(int idboletadecompra){
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM BOLETA_DE_COMPRA WHERE IdBoleta = :idboletadecompra";
            return con.createQuery(sql).addParameter("IdBoleta",idboletadecompra).executeAndFetch(boletadecompra.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // Delete

    @Override
    public void Borrarboleta(int idboletadecompra) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM BOLETA_DE_COMPRA WHERE IdBoleta = :idboletadecompra";
            con.createQuery(sql).addParameter("IdBoleta",idboletadecompra).executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
