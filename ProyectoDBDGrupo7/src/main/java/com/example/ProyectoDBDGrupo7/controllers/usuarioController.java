package com.example.ProyectoDBDGrupo7.controllers;

import com.example.ProyectoDBDGrupo7.models.usuario;
import com.example.ProyectoDBDGrupo7.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    @RestController: Marca la clase como un controlador REST, indicando que los métodos de la clase responderán a las
    solicitudes HTTP y devolverán datos en formato JSON o XML
 */

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    private usuarioService usuarioService;

    // @Autowired Indica a Spring que debe inyectar una instancia de usuarioService en esta clase
    @Autowired
    public usuarioController(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // CREATE
    @PostMapping("/create")
    @ResponseBody
    public usuario create(@RequestBody usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    // READ
    // @GetMapping("/get"): Mapea las solicitudes HTTP GET a /usuario/get a este método
    // @ResponseBody: Indica que el valor devuelto por el método debe ser el cuerpo de la respuesta HTTP
    @GetMapping("/get")
    @ResponseBody
    public List<usuario> getAllUsuarios() {
        return usuarioService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<usuario> getUsuario(@PathVariable int id) {
        return usuarioService.getUserById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public usuario updateUsuario(@PathVariable int id, @RequestBody usuario usuario) {
        return usuarioService.updateUser(usuario, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        usuarioService.deleteUser(id);
    }

    //LOGIN
    @PostMapping("/login")
    public usuario login(@RequestBody usuario usuario) {
        return usuarioService.loginUser(usuario.getCorreo(),usuario.getContraseña());
    }
}
