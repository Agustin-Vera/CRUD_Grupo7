package com.example.ProyectoDBDGrupo7.services;

import com.example.ProyectoDBDGrupo7.models.usuarioValoraProducto;
import com.example.ProyectoDBDGrupo7.repositories.usuarioValoraProductoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioValoraProductoService {

    private usuarioValoraProductoRepositoryImp usuarioValoraProductoRepository;

    @Autowired
    public usuarioValoraProductoService(usuarioValoraProductoRepositoryImp usuarioValoraProductoRepository) {
        this.usuarioValoraProductoRepository = usuarioValoraProductoRepository;
    }

    // CREATE
    public usuarioValoraProducto crearUsuarioValoraProducto(usuarioValoraProducto usuarioValoraProducto) {
        return usuarioValoraProductoRepository.create(usuarioValoraProducto);
    }

    // READ
    public List<usuarioValoraProducto> getAll() {
        return usuarioValoraProductoRepository.getAllUsuarioValoraProducto();
    }

    public List<usuarioValoraProducto> getUsuarioValoraProductoById(int id) {
        return usuarioValoraProductoRepository.getUsuarioValoraProducto(id);
    }

    // UPDATE
    public usuarioValoraProducto updateUsuarioValoraProducto(usuarioValoraProducto usuarioValoraProducto, int id) {
        return usuarioValoraProductoRepository.update(usuarioValoraProducto, id);
    }

    // DELETE
    public void deleteUsuarioValoraProducto(int id) {
        usuarioValoraProductoRepository.borrarUsuarioValoraProducto(id);
    }
}

