package com.example.ProyectoDBDGrupo7.models;

public class productoCategoriaProducto {
    private Long idProductoCategoria;
    private Integer idProducto;
    private Integer idCategoriaProducto;

    public productoCategoriaProducto(Long idProductoCategoria, Integer idProducto, Integer idCategoriaProducto) {
        this.idProductoCategoria = idProductoCategoria;
        this.idProducto = idProducto;
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public Long getIdProductoCategoria() {
        return idProductoCategoria;
    }

    public void setIdProductoCategoria(Long idProductoCategoria) {
        this.idProductoCategoria = idProductoCategoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    @Override
    public String toString() {
        return "productoCategoriaProducto{" +
                "idProductoCategoria=" + idProductoCategoria +
                ", idProducto=" + idProducto +
                ", idCategoriaProducto=" + idCategoriaProducto +
                '}';
    }
}
