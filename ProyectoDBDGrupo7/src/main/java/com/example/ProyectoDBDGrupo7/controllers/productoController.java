package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.producto;
import com.example.ProyectoDBDGrupo7.services.productoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin //permitiendo que tu API sea accesible desde otros dominios. Es útil durante el desarrollo para probar la API desde diferentes orígenes (como localhost en puertos diferentes).
@RestController //Marca la clase como un controlador de Spring, donde cada metodo retorna un objeto que es automáticamente serializado en JSON y enviado como respuesta HTTP.
@RequestMapping("/productos") //Define la URL base para todos los endpoints de este controlador. Todos los métodos de la clase tendrán rutas que comiencen con /productos.
public class productoController {
    private final productoService productoService;
    //Declara un campo para el servicio productoService que será utilizado por el controlador.

    @Autowired // Indica a Spring que debe inyectar automáticamente una instancia de productoService cuando se construya este controlador.
    public productoController(productoService productoService) {
        this.productoService = productoService;
    }

    //CREATE
    @PostMapping("/create") //Define que este metodo manejará solicitudes HTTP POST en la ruta /productos/create.
    @ResponseBody //Se asegura de que el objeto retornado (producto) se serialice automáticamente en JSON (aunque no es necesario en un @RestController).
    public producto create(@RequestBody producto producto) { //Indica que el cuerpo de la solicitud (en formato JSON) debe ser mapeado a un objeto producto.
        System.out.println("Se ha publicado el producto:"+"\n"+producto.toString());
        return productoService.crearProducto(producto); //Llama al metodo crearProducto del servicio para guardar el nuevo producto en la base de datos.
    }

    //READ
    @GetMapping("/get") //Define que este metodo manejará solicitudes HTTP GET en la ruta /productos/get.
    @ResponseBody
    public List<producto> getAllProductos() {
        return productoService.getAllProductos(); //Llama al metodo del servicio para recuperar todos los productos de la base de datos.
    }

    @GetMapping("/get/{id}") //@GetMapping("/get/{id}"): Define que este metodo manejará solicitudes HTTP GET en la ruta /productos/get/{id}, donde {id} es un parámetro en la URL.
    @ResponseBody
    public producto getProducto(@PathVariable int id) { //Indica que el valor {id} en la URL se pasará como argumento id al metodo.
        return productoService.getProductoById(id); //Llama al metodo del servicio para recuperar un producto específico por su ID.
    }

    //UPDATE
    @PutMapping("/update/{id}") //Define que este metodo manejará solicitudes HTTP PUT en la ruta /productos/update/{id}.
    @ResponseBody
    public producto updateProducto(@RequestBody producto producto, @PathVariable int id) {
        return productoService.updateProducto(producto, id); //Llama al servicio para actualizar el producto con el ID dado utilizando la información proporcionada en el cuerpo de la solicitud
    }

    //DELETE
    @DeleteMapping("/delete/{id}") //@DeleteMapping("/delete/{id}"): Define que este metodo manejará solicitudes HTTP DELETE en la ruta /productos/delete/{id}.
    @ResponseBody
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id); //Llama al servicio para eliminar el producto con el ID dado.
    }
}
