package com.example.ProyectoDBDGrupo7.repositories;


import com.example.ProyectoDBDGrupo7.models.medioDePago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class medioDePagoRepositoryImp implements medioDePagoRepository {
    private final Sql2o sql2o;

    @Autowired
    public medioDePagoRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    //Create
    @Override
    public medioDePago create(medioDePago medioDePago) {
        String sql = "INSERT INTO MEDIO_DE_PAGO(NombreMedioPago, DescripcionMedioPago)" +
                "VALUES(:NombreMedioPago, :DescripcionMedioPago)" +
                "RETURNING idMedioPago;";

        try (Connection con = sql2o.open()) {
            long idmedioDePago = con.createQuery(sql, true)
                    .addParameter("NombreMedioPago", medioDePago.getNombreMedioDePago())
                    .addParameter("DescripcionMedioPago", medioDePago.getDescripcionMedioDePago())
                    .executeUpdate()
                    .getKey(Long.class);
            medioDePago.setIdMedioDePago(idmedioDePago);
            return medioDePago;
        }
        catch (Exception e) {
            System.out.println("Error al creal el medio de pago: " + e.getMessage());
            return null;
        }
    }

    //READ
    @Override
    public List<medioDePago> getAll() {
        String sql = "SELECT * FROM MEDIO_DE_PAGO ORDER BY idMedioPago ASC";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(medioDePago.class);

        }
        catch (Exception e){
            System.out.println("Error al consultar los medios de pago: " + e.getMessage());
            return null;
        }
    }

    @Override
    public medioDePago getMedioDePago(int id) {
        String sql = "SELECT * FROM MEDIO_DE_PAGO WHERE idMedioPago = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(medioDePago.class);
        }
        catch (Exception e){
            System.out.println("Error al consultar el medio de pago: " + e.getMessage());
            return null;
        }

    }

    //UPDATE
    @Override
    public medioDePago update(medioDePago medioDePago, int idmediopago) {
        String sql = "UPDATE MEDIO_DE_PAGO SET nombremediopago = :nombremediopago," +
                "descripcionmediopago  = :descripcionmediopago WHERE idmediopago = :idmediopago";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idmediopago", idmediopago)
                    .addParameter("nombremediopago", medioDePago.getNombreMedioDePago())
                    .addParameter("descripcionmediopago", medioDePago.getDescripcionMedioDePago())
                    .executeUpdate();
            return medioDePago;
        } catch (Exception e) {
            System.out.println("Error al actualizar el medio de pago: " + e.getMessage());
            return null;
        }
    }


    //DELETE
    @Override
    public void deleteMedioDePago(int id){
        String sql = "DELETE FROM MEDIO_DE_PAGO WHERE idMedioPago = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
}
