package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.rolPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class rolPermisoRepositoryImp implements rolPermisoRepository {
    private final Sql2o sql2o;

    @Autowired
    public rolPermisoRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    @Override
    public rolPermiso create(rolPermiso rolPermiso) {
        String sql = "INSERT INTO ROL_PERMISO(IdPermiso, IdRol)\n" +
                "VALUES (:IdPermiso, :IdRol)";

        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("IdPermiso", rolPermiso.getIdPermiso())
                    .addParameter("IdRol", rolPermiso.getIdRol())
                    .executeUpdate()
                    .getKey(Long.class);

            rolPermiso.setIdRolPermiso(id);
            return rolPermiso;
        }
        catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
            return null;
        }
    }

    //Read
    @Override
    public List<rolPermiso> getAll() {
        String sql = "SELECT * FROM ROL_PERMISO ORDER BY IdRolPermiso ASC";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(rolPermiso.class);

        }
        catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
            return null;
        }
    }

    @Override
    public rolPermiso getById(int id) {
        String sql = "SELECT * FROM ROL_PERMISO WHERE IdRolPermiso = :id";
        try (Connection conn = sql2o.open()) {
            List<rolPermiso> resultados = conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(rolPermiso.class);

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
    public rolPermiso update(rolPermiso rolPermiso, int id) {
        String sql = "UPDATE ROL_PERMISO SET IdPermiso = :IdPermiso , IdRol =:IdRol WHERE IdRolPermiso = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdPermiso",rolPermiso.getIdPermiso())
                    .addParameter("IdRol",rolPermiso.getIdRol())
                    .executeUpdate();
            return rolPermiso;
        }
        catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM ROL_PERMISO WHERE IdRolPermiso  = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar"+e.getMessage());
        }
    }
}
