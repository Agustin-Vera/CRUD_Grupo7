package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.usuarioPublicaProducto;
import com.example.ProyectoDBDGrupo7.repositories.usuarioPublicaProductoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioPublicaProductoService {

    private usuarioPublicaProductoRepositoryImp usuarioPublicaProductoRepository;

    @Autowired
    public usuarioPublicaProductoService(usuarioPublicaProductoRepositoryImp usuarioPublicaProductoRepository) {
        this.usuarioPublicaProductoRepository = usuarioPublicaProductoRepository;
    }

    // CREATE
    public usuarioPublicaProducto crearUsuarioPublicaProducto(usuarioPublicaProducto usuarioPublicaProducto) {
        return usuarioPublicaProductoRepository.create(usuarioPublicaProducto);
    }

    // READ
    public List<usuarioPublicaProducto> getAll() {
        return usuarioPublicaProductoRepository.getAllUsuarioPublicaProducto();
    }

    public List<usuarioPublicaProducto> getUsuarioPublicaProductoById(int id){
        return usuarioPublicaProductoRepository.getUsuarioPublicaProducto(id);
    }

    // UPDATE
    public usuarioPublicaProducto updateUsuarioPublicaProducto(usuarioPublicaProducto usuarioPublicaProducto, int id) {
        return usuarioPublicaProductoRepository.update(usuarioPublicaProducto, id);
    }

    // DELETE
    public void deleteUsuarioPublicaProducto(int id) {
        usuarioPublicaProductoRepository.borrarUsuarioPublicaProducto(id);
    }

}
