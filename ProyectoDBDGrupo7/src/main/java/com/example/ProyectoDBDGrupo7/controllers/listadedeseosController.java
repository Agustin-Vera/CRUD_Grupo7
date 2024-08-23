package com.example.ProyectoDBDGrupo7.controllers;


import com.example.ProyectoDBDGrupo7.models.listaDeseosProducto;
import com.example.ProyectoDBDGrupo7.models.listadeseos;
import com.example.ProyectoDBDGrupo7.services.listadeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/listadeseos")

public class listadedeseosController {

    private final listadeseosService listadeseosService;

    @Autowired
    public listadedeseosController(listadeseosService listadeseosService)
    {this.listadeseosService = listadeseosService;}

    // Create
    @PostMapping("/create")
    @ResponseBody
    public listadeseos crearlistadeseos(@RequestBody listadeseos listadeseos)
    {return listadeseosService.CrearListaDeseos(listadeseos);}

    // Read
    @GetMapping("/get")
    @ResponseBody
    public List<listadeseos> GetAll()
    {return listadeseosService.GetAllLists();}

    @GetMapping("/get/{id}")
    @ResponseBody
    public listadeseos UserList(@PathVariable int id)
    {return listadeseosService.GetListById(id);}

    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public listadeseos updateIdUsuario(@RequestBody listadeseos listadeseos, @PathVariable int id) {
        return listadeseosService.updateListaDeseos(listadeseos, id);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void Delete(@PathVariable int id)
    { listadeseosService.delete(id);}


}
