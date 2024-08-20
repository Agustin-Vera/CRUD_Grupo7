package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.listaDeseosProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class listaDeseosProductoRepositoryImp implements listaDeseosProductoRepository {
    private final Sql2o sql2o;

    @Autowired
    public listaDeseosProductoRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    @Override
    public listaDeseosProducto create(listaDeseosProducto listaDeseosProducto) {
        String sql = "INSERT INTO LISTA_DESEOS_PRODUCTO(IdListaDeseos, IdProducto)" +
                "VALUES (:IdListaDeseos, :IdProducto) RETURNING idListaProducto;";

        try (Connection conn = sql2o.open()) {
            long id = conn.createQuery(sql,true)
                    .addParameter("IdListaDeseos",listaDeseosProducto.getIdListaDeseos())
                    .addParameter("IdProducto",listaDeseosProducto.getIdProducto())
                    .executeUpdate()
                    .getKey(Long.class);

            listaDeseosProducto.setIdListaProducto(id);
            return listaDeseosProducto;
        }
        catch (Exception e) {
            System.out.println("Error al crear la unión entre producto y la lista de deseos"+e.getMessage());
            return null;
        }
    }

    //READ
    @Override
    public List<listaDeseosProducto> getAll() {
        String sql = "SELECT * FROM LISTA_DESEOS_PRODUCTO ORDER BY idLista_Producto ASC";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(listaDeseosProducto.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar las uniones entre productos y listas de deseos"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<listaDeseosProducto> getListaDeseosProducto(int id){
        String sql = "SELECT * FROM LISTA_DESEOS_PRODUCTO WHERE idLista_Producto = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(listaDeseosProducto.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar la unión entre el producto y su lista de deseos"+e.getMessage());
            return null;
        }
    }

    //UPDATE
    @Override
    public listaDeseosProducto update(listaDeseosProducto listaDeseosProducto, int id) {
        String sql = "UPDATE LISTA_DESEOS_PRODUCTO SET IdProducto = :IdProducto WHERE idLista_Producto = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdProducto",listaDeseosProducto.getIdProducto())
                    .executeUpdate();
            return listaDeseosProducto;
        }
        catch (Exception e) {
            System.out.println("Error al actualizar la unión entre el producto y su lista de deseos"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM LISTA_DESEOS_PRODUCTO WHERE idLista_Producto = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar la unión entre el producto y su lista de deseos"+e.getMessage());
        }
    }
}
