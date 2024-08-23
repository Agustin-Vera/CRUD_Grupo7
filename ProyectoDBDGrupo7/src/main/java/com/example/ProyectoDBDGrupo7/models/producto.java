package com.example.ProyectoDBDGrupo7.models;

public class producto {
    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String tipoProducto;
    private Integer stock;
    private Integer precio;
    private String urlProducto;

    public producto(Long idProducto, String nombreProducto, String descripcionProducto, String tipoProducto, Integer stock, Integer precio, String url) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.tipoProducto = tipoProducto;
        this.stock = stock;
        this.precio = precio;
        this.urlProducto = url;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getUrl() {
        return urlProducto;
    }

    public void setUrl(String url) {
        this.urlProducto = url;
    }

    @Override
    public String toString() {
        return "producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", url='" + urlProducto + '\'' +
                '}';
    }
}
