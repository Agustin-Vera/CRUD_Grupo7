package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.productoCarroDeCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class productoCarroDeComprasRepositoryImp implements productoCarroDeComprasRepository {
    private final Sql2o sql2o;

    @Autowired
    public productoCarroDeComprasRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    @Override
    public productoCarroDeCompras create(productoCarroDeCompras productoCarroDeCompras) {
        String sql = "INSERT INTO PRODUCTO_CARRODECOMPRAS(IdProducto, IdCarro)\n" +
                "VALUES (:IdProducto, :IdCarro)";

        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("IdProducto", productoCarroDeCompras.getIdProducto())
                    .addParameter("IdCarro", productoCarroDeCompras.getIdCarro())
                    .executeUpdate()
                    .getKey(Long.class);

            productoCarroDeCompras.setIdProductoCarro(id);
            return productoCarroDeCompras;
        }
        catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
            return null;
        }
    }

    //Read
    @Override
    public List<productoCarroDeCompras> getAll() {
        String sql = "SELECT * FROM PRODUCTO_CARRODECOMPRAS ORDER BY IdProducto_Carro ASC";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(productoCarroDeCompras.class);

        }
        catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
            return null;
        }
    }

    @Override
    public productoCarroDeCompras getById(int id) {
        String sql = "SELECT * FROM PRODUCTO_CARRODECOMPRAS WHERE IdProducto_Carro = :id";
        try (Connection conn = sql2o.open()) {
            List<productoCarroDeCompras> resultados = conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(productoCarroDeCompras.class);

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
    public productoCarroDeCompras update(productoCarroDeCompras productoCarroDeCompras, int id) {
        String sql = "UPDATE PRODUCTO_CARRODECOMPRAS SET IdProducto = :IdProducto WHERE IdProducto_Carro = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdProducto",productoCarroDeCompras.getIdProducto())
                    .executeUpdate();
            return productoCarroDeCompras;
        }
        catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM PRODUCTO_CARRODECOMPRAS WHERE IdProducto_Carro = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar"+e.getMessage());
        }
    }
}
