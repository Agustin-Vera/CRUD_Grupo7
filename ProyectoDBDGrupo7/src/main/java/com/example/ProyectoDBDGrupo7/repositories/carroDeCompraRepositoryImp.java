package com.example.ProyectoDBDGrupo7.repositories;


import com.example.ProyectoDBDGrupo7.models.carroDeCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class carroDeCompraRepositoryImp implements carroDeCompraRepository {
    private final Sql2o sql2o;

    @Autowired
    public carroDeCompraRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    //Create
    @Override
    public carroDeCompras create(carroDeCompras carroDeCompras) {
        String sql = "INSERT INTO CARRO_DE_COMPRAS(IdUsuario)" +
                "VALUES(:IdUsuario)" +
                "RETURNING IdUsuario;";

        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("IdUsuario", carroDeCompras.getIdUsuario())
                    .executeUpdate()
                    .getKey(Long.class);

            carroDeCompras.setIdCarro(id);
            return carroDeCompras;
        }
        catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
            return null;
        }
    }

    //Read
    @Override
    public List<carroDeCompras> getAllcarroDeCompras() {
        String sql = "SELECT * FROM CARRO_DE_COMPRAS ORDER BY idcarroDeCompras ASC";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(carroDeCompras.class);
            // Mapea los resultados a la clase Producto
        }
        catch (Exception e) {
            System.out.println("Error al consultar los productos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public carroDeCompras getcarroDeComprasById(int id) {
        String sql = "SELECT * FROM CARRO_DE_COMPRAS WHERE idCarro = :id";
        try (Connection conn = sql2o.open()) {
            List<carroDeCompras> resultados = conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(carroDeCompras.class);

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
    public carroDeCompras update(carroDeCompras carroDeCompras, int id) {
        String sql = "UPDATE CARRO_DE_COMPRAS SET IdUsuario = :IdUsuario WHERE idcarroDeCompras = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdUsuario",carroDeCompras.getIdUsuario())
                    .executeUpdate();
            return carroDeCompras;
        }
        catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deletecarroDeCompras(int id) {
        String sql = "DELETE FROM PRODUCTO_CARRODECOMPRAS WHERE PRODUCTO_CARRODECOMPRAS.IdcarroDeCompras  = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar"+e.getMessage());
        }
    }
}
