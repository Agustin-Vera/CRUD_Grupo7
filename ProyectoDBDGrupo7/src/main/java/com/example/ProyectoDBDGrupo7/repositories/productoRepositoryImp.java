package com.example.ProyectoDBDGrupo7.repositories;

import com.example.ProyectoDBDGrupo7.models.producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class productoRepositoryImp implements productoRepository {
    private final Sql2o sql2o;

    @Autowired
    public productoRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    //@Override Indica que este metodo está sobrescribiendo un metodo de una interfaz o clase base.
    //En este caso, create está sobrescribiendo un metodo de la interfaz o clase base que define este contrato.
    @Override
    public producto create(producto producto) {
        // Define la consulta SQL para insertar un nuevo registro en la tabla PRODUCTO
        String sql = "INSERT INTO PRODUCTO(NombreProducto, DescripcionProducto, TipoProducto, Stock, Precio, UrlProducto) " +
                "VALUES (:NombreProducto, :DescripcionProducto, :TipoProducto, :Stock, :Precio, :UrlProducto) " +
                "RETURNING idProducto"; // Usa RETURNING para obtener el ID generado

        try (Connection conn = sql2o.open()) {
            // Ejecuta la consulta de inserción y obtiene la clave primaria generada (ID)
            long id = conn.createQuery(sql, true)
                    .addParameter("NombreProducto", producto.getNombreProducto())
                    .addParameter("DescripcionProducto", producto.getDescripcionProducto())
                    .addParameter("TipoProducto", producto.getTipoProducto())
                    .addParameter("Stock", producto.getStock())
                    .addParameter("Precio", producto.getPrecio())
                    .addParameter("UrlProducto", producto.getUrl())
                    .executeUpdate() // Ejecuta la consulta de inserción en la base de datos
                    .getKey(Long.class); // Obtiene el ID generado

            producto.setIdProducto(id); // Asigna el ID generado al objeto producto
            return producto; // Retorna el objeto producto con el ID asignado

        }
        catch (Exception e) {
            // Imprime el error en caso de excepción
            System.out.println("Error al crear el producto: " + e.getMessage());
            return null; // Retorna null para indicar que la operación falló
        }
    }

    //READ
    @Override
    public List<producto> getAll() {
        // Define la consulta SQL para seleccionar todos los registros de la tabla PRODUCTO
        String sql = "SELECT * FROM PRODUCTO ORDER BY idProducto ASC";
        try (Connection conn = sql2o.open()) { // Intenta abrir una conexión a la base de datos usando Sql2o
            // Ejecuta la consulta SQL y recupera los resultados como una lista de objetos Producto
            return conn.createQuery(sql).executeAndFetch(producto.class);
            // Mapea los resultados a la clase Producto
        }
        catch (Exception e) {
            System.out.println("Error al consultar los productos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public producto getProducto(int id) {
        // Define la consulta SQL para seleccionar un registro específico de la tabla PRODUCTO
        String sql = "SELECT * FROM PRODUCTO WHERE idProducto = :id";
        try (Connection conn = sql2o.open()) {
            // Ejecuta la consulta SQL con el parámetro proporcionado y recupera el primer resultado como un objeto Producto
            return conn.createQuery(sql)
                    .addParameter("id",id) // Asocia el valor del parámetro :id con el valor proporcionado
                    .executeAndFetchFirst(producto.class); // Mapea el primer resultado a la clase Producto
        }
        catch (Exception e) {
            System.out.println("Error al consultar el producto: " + e.getMessage());
            return null;
        }
    }

    //UPDATE
    @Override
    public producto update(producto producto, int id) { //Define el metodo update que recibe un objeto producto y un id como parámetros. El metodo devuelve un objeto de tipo producto.
        String sql = "UPDATE PRODUCTO SET Stock = :Stock WHERE idProducto = :id";
        //Abre una conexión a la base de datos utilizando Sql2o. El bloque try-with-resources garantiza
        //que la conexión se cierre automáticamente después de que se complete el bloque,
        //incluso si ocurre una excepción.
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql) //Crea una consulta SQL a partir de la cadena sql definida anteriormente.
                    .addParameter("id", id) //Asocia el valor del parámetro :id en la consulta SQL con el valor del id pasado como argumento al metodo.
                    .addParameter("Stock", producto.getStock()) //Asocia el valor del parámetro :Stock en la consulta SQL con el valor de Stock obtenido del objeto producto.
                    .executeUpdate(); //Ejecuta la consulta SQL de actualización en la base de datos. No se espera ningún resultado devuelto, ya que esta consulta solo modifica los datos.
            return producto; //Retorna el objeto producto que se ha actualizado, aunque en realidad el objeto en sí no se ha modificado, sino que solo se ha actualizado su información en la base de datos.
        }
        catch (Exception e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return null; //Retorna null si ocurre una excepción, indicando que la operación de actualización falló.
        }
    }

    //DELETE
    @Override
    public void delete(int id){
        String sql = "DELETE FROM PRODUCTO WHERE idProducto = :id";
        try (Connection conn = sql2o.open()) {
            // Ejecuta la consulta SQL con el parámetro proporcionado
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
            // Ejecuta la consulta de eliminación en la base de datos
        }
        catch (Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
}
