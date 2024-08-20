package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.usuario;
import com.example.ProyectoDBDGrupo7.models.usuarioValoraProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class usuarioValoraProductoRepositoryImp implements usuarioValoraProductoRepository {

    private Sql2o sql2o;

    @Autowired
    public usuarioValoraProductoRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    // CREATE
    public usuarioValoraProducto create(usuarioValoraProducto usuarioValoraProducto) {
        String sql = "INSERT INTO usuario_valora_producto(idusuario, idproducto, valoracion) VALUES (:idusuario, :idproducto, :valoracion)";
        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("idusuario", usuarioValoraProducto.getIdUsuario())
                    .addParameter("idproducto", usuarioValoraProducto.getIdProducto())
                    .addParameter("valoracion", usuarioValoraProducto.getValoracion())
                    .executeUpdate()
                    .getKey(Long.class);
            usuarioValoraProducto.setIdValorado(id);
            return usuarioValoraProducto;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // READ
    public List<usuarioValoraProducto> getAllUsuarioValoraProducto() {
        String sql = "SELECT * FROM usuario_valora_producto";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(usuarioValoraProducto.class);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<usuarioValoraProducto> getUsuarioValoraProducto(int id) {
        String sql = "SELECT * FROM usuario_valora_producto WHERE idvalorado = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id", id).executeAndFetch(usuarioValoraProducto.class);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // UPDATE
    public usuarioValoraProducto update(usuarioValoraProducto usuarioValoraProducto, int idvalorado) {
        String sql = "UPDATE usuario_valora_producto SET idusuario=:idusuario, idproducto=:idproducto, valoracion=:valoracion WHERE idvalorado =:idvalorado";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql, true)
                    .addParameter("idvalorado", idvalorado)
                    .addParameter("idusuario", usuarioValoraProducto.getIdUsuario())
                    .addParameter("idproducto", usuarioValoraProducto.getIdProducto())
                    .addParameter("valoracion", usuarioValoraProducto.getValoracion())
                    .executeUpdate();
            return usuarioValoraProducto;
        }
        catch (Exception e) {
            System.out.println("hola");
            System.out.println(e);
        }
        return null;
    }

    // DELETE
    public void borrarUsuarioValoraProducto(int id) {
        String sql = "DELETE FROM usuario_valora_producto WHERE idvalorado = :idvalorado";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("idvalorado", id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
