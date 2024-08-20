package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.usuarioPublicaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class usuarioPublicaProductoRepositoryImp implements usuarioPublicaProductoRepository{

    private Sql2o sql2o;

    @Autowired
    public usuarioPublicaProductoRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    @Override
    public usuarioPublicaProducto create(usuarioPublicaProducto usuarioPublicaProducto){
        String sql = "INSERT INTO usuario_publica_producto(idproducto, idusuario)" +
                "VALUES (:idproducto, :idusuario)";
        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("idproducto", usuarioPublicaProducto.getIdProducto())
                    .addParameter("idusuario", usuarioPublicaProducto.getIdUsuario())
                    .executeUpdate()
                    .getKey(Long.class);
            usuarioPublicaProducto.setIdPublicado(id);
            return usuarioPublicaProducto;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // READ
    @Override
    public List<usuarioPublicaProducto> getAllUsuarioPublicaProducto() {
        String sql = "SELECT * FROM usuario_publica_producto";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(usuarioPublicaProducto.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<usuarioPublicaProducto> getUsuarioPublicaProducto(int id) {
        String sql = "SELECT * FROM usuario_publica_producto WHERE idusuario = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id", id).executeAndFetch(usuarioPublicaProducto.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // UPDATE
    @Override
    public usuarioPublicaProducto update(usuarioPublicaProducto usuarioPublicaProducto, int id) {
        String sql = "UPDATE usuario_publica_producto SET idproducto=:idproducto, idusuario=:idusuario WHERE idpublicado=:idpublicado";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql, true)
                    .addParameter("idpublicado", id)
                    .addParameter("idproducto", usuarioPublicaProducto.getIdProducto())
                    .addParameter("idusuario", usuarioPublicaProducto.getIdUsuario())
                    .executeUpdate();
            return usuarioPublicaProducto;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // DELETE
    public void borrarUsuarioPublicaProducto(int id) {
        String sql = "DELETE FROM usuario_publica_producto WHERE idpublicado=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
