package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.usuario;
import com.example.ProyectoDBDGrupo7.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

/*
    @Repository: Marca la clase como un componente de repositorio de Spring, indicando que esta clase se encarga
    de la interacción con la base de datos
 */
@Repository
public class usuarioRepositoryImp implements usuarioRepository {

    private Sql2o sql2o;

    // @Autowired: Indica a Spring que debe inyectar una instancia de Sql2o en esta clase
    @Autowired
    public usuarioRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;

    }

    // CREATE
    @Override
    public usuario create(usuario usuario) {
        String sql = "INSERT INTO USUARIO(NombreUsuario,Correo,Contraseña,IdRol)" +
                "VALUES (:NombreUsuario, :Correo, :Contraseña, :IdRol)";
        try (Connection con = sql2o.open()) {
            long id = con.createQuery(sql, true)
                    .addParameter("NombreUsuario", usuario.getNombreusuario())
                    .addParameter("Correo", usuario.getCorreo())
                    .addParameter("Contraseña", usuario.getContraseña())
                    .addParameter("IdRol", usuario.getIdrol())
                    .executeUpdate()
                    .getKey(Long.class);

            usuario.setId(id); // Asignar el ID generado (dado que se declara como serial) al objeto usuario
            return usuario;
        }
        catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    /*
    Método getAllUsers: Proporciona una implementación del método para recuperar todos los usuarios de la base de datos:
        Define y ejecuta una consulta SQL.
        Utiliza Sql2o para manejar la conexión y el mapeo de los resultados de la base de datos a objetos usuario.
     */
    // READ
    @Override
    public List<usuario> getAllUsers() {
        String sql = "SELECT * FROM usuario";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(usuario.class);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<usuario> getUser(int id){
        String sql = "SELECT * FROM usuario WHERE idusuario = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id", id).executeAndFetch(usuario.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // UPDATE
    @Override
    public usuario update(usuario usuario, int idusuario) {
        String sql = "UPDATE USUARIO SET nombreusuario = :nombreusuario, correo = :correo, \"contraseña\" = :contraseña, idrol = :idrol WHERE idusuario = :idusuario";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql, true)
                    .addParameter("idusuario", idusuario)
                    .addParameter("nombreusuario", usuario.getNombreusuario())
                    .addParameter("correo", usuario.getCorreo())
                    .addParameter("contraseña", usuario.getContraseña())
                    .addParameter("idrol", usuario.getIdrol())
                    .executeUpdate();
            return usuario;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return usuario;
    }

    // DELETE
    @Override
    public void borrarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE idusuario = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
