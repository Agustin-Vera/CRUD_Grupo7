package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.productoCategoriaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class productoCategoriaProductoRepositoryImp implements productoCategoriaProductoRepository {
    private final Sql2o sql2o;

    @Autowired
    public productoCategoriaProductoRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    @Override
    public productoCategoriaProducto create(productoCategoriaProducto productoCategoriaProducto) {
        String sql = "INSERT INTO PRODUCTO_CATEGORIAPRODUCTO(IdProducto, IdCategoriaProducto)" +
                "VALUES (:IdProducto, :IdCategoriaProducto) RETURNING idProducto_Categoria";

        try (Connection conn = sql2o.open()) {
            long id = conn.createQuery(sql,true)
                    .addParameter("IdProducto",productoCategoriaProducto.getIdProducto())
                    .addParameter("IdCategoriaProducto",productoCategoriaProducto.getIdCategoriaProducto())
                    .executeUpdate()
                    .getKey(Long.class);

            productoCategoriaProducto.setIdProductoCategoria(id);
            return productoCategoriaProducto;
        }
        catch (Exception e) {
            System.out.println("Error al crear la unión entre producto y categoria"+e.getMessage());
            return null;
        }
    }

    //READ
    @Override
    public List<productoCategoriaProducto> getAll() {
        String sql = "SELECT * FROM PRODUCTO_CATEGORIAPRODUCTO ORDER BY idProducto_Categoria ASC";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(productoCategoriaProducto.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar las uniones entre producto y categorias"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<productoCategoriaProducto> getProductoCategoriaProducto(int id){
        String sql = "SELECT * FROM PRODUCTO_CATEGORIAPRODUCTO WHERE idProducto_Categoria = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(productoCategoriaProducto.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar la unión entre el producto y su categoria"+e.getMessage());
            return null;
        }
    }

    //UPDATE
    @Override
    public productoCategoriaProducto update(productoCategoriaProducto productoCategoriaProducto, int id) {
        String sql = "UPDATE PRODUCTO_CATEGORIAPRODUCTO SET IdProducto = :IdProducto WHERE idProducto_Categoria = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdProducto",productoCategoriaProducto.getIdProducto())
                    .executeUpdate();
            return productoCategoriaProducto;
        }
        catch (Exception e) {
            System.out.println("Error al actualizar la unión entre el producto y su categoria"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM PRODUCTO_CATEGORIAPRODUCTO WHERE idProducto_Categoria = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar la unión entre el producto y su categoria"+e.getMessage());
        }
    }
}
