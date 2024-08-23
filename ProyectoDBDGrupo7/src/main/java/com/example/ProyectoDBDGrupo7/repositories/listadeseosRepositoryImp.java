package com.example.ProyectoDBDGrupo7.repositories;


import com.example.ProyectoDBDGrupo7.models.carroDeCompras;
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
            String sql = "INSERT INTO lista_deseos(IdUsuario) VALUES (:IdUsuario)";
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
            String sql = "SELECT * FROM lista_deseos";
            return con.createQuery(sql).executeAndFetch(listadeseos.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public listadeseos GetListForId(int IdUsuario){
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM lista_deseos WHERE IdUsuario = :IdUsuario";
            return con.createQuery(sql).addParameter("IdUsuario",IdUsuario).executeAndFetchFirst(listadeseos.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //UPDATE
    @Override
    public listadeseos update(listadeseos listadeseos, int id) {
        String sql = "UPDATE LISTA_DESEOS SET IdUsuario = :IdUsuario WHERE idlistadeseos = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdUsuario",listadeseos.getIdUsuario())
                    .executeUpdate();
            return listadeseos;
        }
        catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    // Delete
    @Override
    public void Delete(int idlistadeseos){
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM lista_deseos WHERE idlistadeseos = :idlistadeseos";
            con.createQuery(sql).addParameter("idlistadeseos",idlistadeseos).executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
