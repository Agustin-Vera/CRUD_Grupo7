package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class rolRepositoryImp implements rolRepository {
    private final Sql2o sql2o;

    @Autowired
    public rolRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    //Create
    @Override
    public rol createRol(rol rol) {
        String sql = "INSERT INTO ROL(nombrerol)\n" +
                "VALUES (:nombrerol)" +
                "RETURNING idrol;";

        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("nombrerol", rol.getNombreRol())
                    .executeUpdate()
                    .getKey(Long.class);

            rol.setIdRol(id);
            return rol;
        }
        catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
            return null;
        }
    }

    //Read
    @Override
    public List<rol> getAllrol() {
        String sql = "SELECT * FROM ROL ORDER BY idrol ASC";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(rol.class);

        }
        catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
            return null;
        }
    }

    @Override
    public rol getrolById(int id) {
        String sql = "SELECT * FROM ROL WHERE IdRol = :id";
        try (Connection conn = sql2o.open()) {
            List<rol> resultados = conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(rol.class);

            if (!resultados.isEmpty()) {
                return resultados.get(0);
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
            return null;
        }
    }


    //UPDATE
    @Override
    public rol update(rol rol, int id) {
        String sql = "UPDATE ROL SET nombrerol = :nombrerol WHERE idrol = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("nombrerol",rol.getNombreRol())
                    .executeUpdate();
            return rol;
        }
        catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deleterol(int id) {
        String sql = "DELETE FROM ROL WHERE idrol = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar"+e.getMessage());
        }
    }
}