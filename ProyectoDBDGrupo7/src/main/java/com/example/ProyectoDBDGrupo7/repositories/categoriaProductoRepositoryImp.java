package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.categoriaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class categoriaProductoRepositoryImp implements categoriaProductoRepository {
    private final Sql2o sql2o;

    @Autowired
    public categoriaProductoRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    @Override
    public categoriaProducto create(categoriaProducto categoriaProducto) {
        String sql = "INSERT INTO CATEGORIA_PRODUCTO(NombreCategoriaProducto, DescripcionCategoriaProducto) " +
                "VALUES (:NombreCategoriaProducto, :DescripcionCategoriaProducto) " +
                "RETURNING idCategoriaProducto";

        try (Connection conn = sql2o.open()) {
            long id = conn.createQuery(sql,true)
                    .addParameter("NombreCategoriaProducto",categoriaProducto.getNombreCategoriaProducto())
                    .addParameter("DescripcionCategoriaProducto",categoriaProducto.getDescripcionCategoriaProducto())
                    .executeUpdate()
                    .getKey(Long.class);

            categoriaProducto.setIdCategoriaProducto(id);
            return categoriaProducto;

        }
        catch (Exception e) {
            System.out.println("Error al crear la categoria del producto"+e.getMessage());
            return null;
        }
    }

    //READ
    @Override
    public List<categoriaProducto> getAll(){
        String sql = "SELECT * FROM CATEGORIA_PRODUCTO ORDER BY idCategoriaProducto ASC";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(categoriaProducto.class);

        }
        catch (Exception e) {
            System.out.println("Error al consultar las categorias de los productos"+e.getMessage());
            return null;
        }
    }

    @Override
    public categoriaProducto getCategoriaProducto(int id){
        String sql = "SELECT * FROM CATEGORIA_PRODUCTO WHERE idCategoriaProducto = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(categoriaProducto.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar la categoria del producto"+e.getMessage());
            return null;
        }
    }

    //UPDATE
    @Override
    public categoriaProducto update(categoriaProducto categoriaProducto, int id){
        String sql = "UPDATE CATEGORIA_PRODUCTO SET DescripcionCategoriaProducto = :DescripcionCategoriaProducto WHERE idCategoriaProducto = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("DescripcionCategoriaProducto", categoriaProducto.getDescripcionCategoriaProducto())
                    .executeUpdate();
            return categoriaProducto;
        }
        catch (Exception e) {
            System.out.println("Error al actualizar la categoria del producto"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id){
        String sql = "DELETE FROM CATEGORIA_PRODUCTO WHERE idCategoriaProducto = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar la categoria del producto"+e.getMessage());
        }
    }
}
