package com.example.ProyectoDBDGrupo7.models;

public class categoriaProducto {
    private Long idCategoriaProducto;
    private String nombreCategoriaProducto;
    private String descripcionCategoriaProducto;

    public categoriaProducto(Long idCategoriaProducto, String nombreCategoriaProducto, String descripcionCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.descripcionCategoriaProducto = descripcionCategoriaProducto;
    }

    public Long getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Long idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoriaProducto() {
        return nombreCategoriaProducto;
    }

    public void setNombreCategoriaProducto(String nombreCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
    }

    public String getDescripcionCategoriaProducto() {
        return descripcionCategoriaProducto;
    }

    public void setDescripcionCategoriaProducto(String descripcionCategoriaProducto) {
        this.descripcionCategoriaProducto = descripcionCategoriaProducto;
    }

    @Override
    public String toString() {
        return "categoriaProducto{" +
                "idCategoriaProducto=" + idCategoriaProducto +
                ", nombreCategoriaProducto='" + nombreCategoriaProducto + '\'' +
                ", descripcionCategoriaProducto='" + descripcionCategoriaProducto + '\'' +
                '}';
    }
}
