package com.example.ProyectoDBDGrupo7.models;

public class productoCategoriaProducto {
    private Long idProducto_Categoria;
    private Integer idProducto;
    private Integer idCategoriaProducto;

    public productoCategoriaProducto(Long idProductoCategoria, Integer idProducto, Integer idCategoriaProducto) {
        this.idProducto_Categoria = idProductoCategoria;
        this.idProducto = idProducto;
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public Long getIdProductoCategoria() {
        return idProducto_Categoria;
    }

    public void setIdProductoCategoria(Long idProductoCategoria) {
        this.idProducto_Categoria = idProductoCategoria;
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
                "idProductoCategoria=" + idProducto_Categoria +
                ", idProducto=" + idProducto +
                ", idCategoriaProducto=" + idCategoriaProducto +
                '}';
    }
}
