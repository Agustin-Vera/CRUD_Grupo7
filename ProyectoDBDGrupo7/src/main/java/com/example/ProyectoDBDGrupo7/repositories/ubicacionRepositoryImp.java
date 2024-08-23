package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ubicacionRepositoryImp implements ubicacionRepository {

    private Sql2o sql2o;

    @Autowired
    public ubicacionRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    // Create
    @Override
    public ubicacion create(ubicacion ubicacion) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO UBICACION(Region, Comuna, Calle, Numero, IdUsuario)" +
                    "VALUES(:Region, :Comuna, :Calle, :Numero, :IdUsuario)";
            long idubicacion = con.createQuery(sql, true)
                    .addParameter("Region", ubicacion.getRegion())
                    .addParameter("Comuna", ubicacion.getComuna())
                    .addParameter("Calle", ubicacion.getCalle())
                    .addParameter("Numero", ubicacion.getNumero())
                    .addParameter("IdUsuario", ubicacion.getIdUsuario())
                    .executeUpdate()
                    .getKey(Long.class);

            ubicacion.setIdUbicacion(idubicacion);
            return ubicacion;
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    // Read
    // Obtiene la lista de todas las ubicaciones registradas
    @Override
    public List<ubicacion> AllLocations() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM UBICACION";
            return con.createQuery(sql).executeAndFetch(ubicacion.class);
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Obtiene todas las ubicaciones que puede tener un id
    @Override
    public List<ubicacion> LocationForId(int idusuario) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM UBICACION WHERE idusuario = :idusuario";
            return con.createQuery(sql).addParameter("idusuario", idusuario).executeAndFetch(ubicacion.class);
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Update

    // Actualiza los datos necesarios de un usuario en especifico
    @Override
    public ubicacion Update(ubicacion ubicacion, int idubicacion) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE UBICACION SET Region =: Region, Comuna =: Comuna, Calle =: Calle," +
                    " Numero =: Numero , idusuario =: IdUsuario WHERE idubicacion = :idubicacion";
            con.createQuery(sql, true)
                    .addParameter("Region", ubicacion.getRegion())
                    .addParameter("Comuna", ubicacion.getComuna())
                    .addParameter("Calle", ubicacion.getCalle())
                    .addParameter("Numero", ubicacion.getNumero())
                    .addParameter("idusuario", ubicacion.getIdUsuario())
                    .executeUpdate();
            return ubicacion;
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Delete

    // Principalmente funcional a la hora de eliminar un usuario, ya que elimina todas las direcciones que este posea
    @Override
    public void Delete(int idusuario) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM UBICACION WHERE idusuario = :idusuario";
            con.createQuery(sql).addParameter("idusuario", idusuario).executeUpdate();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void DeleteForLocationId(int idubicacion) {
        try (Connection con = sql2o.open()) {
            String sql = "Delete FROM UBICACION WHERE idubicacion = :idubicacion";
            con.createQuery(sql).addParameter("idubicacion", idubicacion).executeUpdate();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
