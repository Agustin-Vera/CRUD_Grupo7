package com.example.ProyectoDBDGrupo7.repositories;


import com.example.ProyectoDBDGrupo7.models.listadeseos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class listadeseosRepositoryImp implements listadeseosRepository {

    private Sql2o sql2o;

    @Autowired
    public listadeseosRepositoryImp(Sql2o sql2o)
    {this.sql2o = sql2o;}

    // Create
    @Override
    public listadeseos create(listadeseos listadeseos){
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO listadeseos(IdUsuario) VALUES (:IdUsuario)";
            long idlistadeseos = con.createQuery(sql,true)
                    .addParameter("IdUsuario",listadeseos.getIdUsuario())
                    .executeUpdate()
                    .getKey(Long.class);

            listadeseos.setIdListaDeseos(idlistadeseos);
            return listadeseos;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // Read
    @Override
    public List<listadeseos> getAllList(){
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM listadeseos";
            return con.createQuery(sql).executeAndFetch(listadeseos.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public listadeseos GetListForId(int IdUsuario){
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM listadeseos WHERE IdUsuario = :IdUsuario";
            return con.createQuery(sql).addParameter("IdUsuario",IdUsuario).executeAndFetchFirst(listadeseos.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // Delete
    @Override
    public void Delete(int IdUsuario){
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM listadeseos WHERE IdUsuario = :IdUsuario";
            con.createQuery(sql).addParameter("IdUsuario",IdUsuario).executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
