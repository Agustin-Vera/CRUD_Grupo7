package com.example.ProyectoDBDGrupo7.models;

public class carroDeCompras {
    private Long idCarro;
    private Integer valorCompra;
    private Integer idUsuario;

    public carroDeCompras(Long idCarro, Integer valorCompra, Integer idUsuario) {
        this.idCarro = idCarro;
        this.valorCompra = valorCompra;
        this.idUsuario = idUsuario;
    }

    public Long getIdCarro() {return idCarro;}

    public void setIdCarro(Long idCarro) {this.idCarro = idCarro;}

    public Integer getValorCompra() {return valorCompra;}

    public void setValorCompra(Integer valorCompra) {this.valorCompra = valorCompra;}

    public Integer getIdUsuario() {return idUsuario;}

    public void setIdUsuario(Integer idUsuario) {this.idUsuario = idUsuario;}


    @Override
    public String toString() {
        return "carroDeCompras{" +
                "idCarro=" + idCarro +
                ", valorCompra='" + valorCompra + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}
