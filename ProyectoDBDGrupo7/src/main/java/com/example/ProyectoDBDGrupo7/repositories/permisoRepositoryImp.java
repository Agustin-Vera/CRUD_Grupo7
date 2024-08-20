package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class permisoRepositoryImp implements permisoRepository {
    private final Sql2o sql2o;

    @Autowired
    public permisoRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    @Override
    public permiso create(permiso permiso) {
        String sql = "INSERT INTO PERMISO(NombrePermiso)\n" +
                "VALUES (:NombrePermiso)";

        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("NombrePermiso", permiso.getNombrePermiso())
                    .executeUpdate()
                    .getKey(Long.class);

            permiso.setIdPermiso(id);
            return permiso;
        }
        catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
            return null;
        }
    }

    //Read
    @Override
    public List<permiso> getAll() {
        String sql = "SELECT * FROM PERMISO ORDER BY idpermiso ASC";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(permiso.class);

        }
        catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
            return null;
        }
    }

    @Override
    public permiso getById(int id) {
        String sql = "SELECT * FROM PERMISO WHERE IdPermiso = :id";
        try (Connection conn = sql2o.open()) {
            List<permiso> resultados = conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(permiso.class);

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
    public permiso update(permiso permiso, int id) {
        String sql = "UPDATE PERMISO SET NombrePermiso = :NombrePermiso WHERE IdPermiso = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("NombrePermiso",permiso.getNombrePermiso())
                    .executeUpdate();
            return permiso;
        }
        catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM PERMISO WHERE NombrePermiso.IdPermiso  = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar"+e.getMessage());
        }
    }
}
