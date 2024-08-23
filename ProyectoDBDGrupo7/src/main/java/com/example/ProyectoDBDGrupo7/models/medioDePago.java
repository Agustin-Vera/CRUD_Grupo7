package com.example.ProyectoDBDGrupo7.models;

public class medioDePago {
    private Long idMedioPago;
    private String nombreMedioPago ;
    private String descripcionMedioPago;

    public medioDePago(Long idMedioDePago, String nombreMedioDePago, String descripcionMedioDePago) {
        this.idMedioPago = idMedioDePago;
        this.nombreMedioPago = nombreMedioDePago;
        this.descripcionMedioPago = descripcionMedioDePago;
    }

    public Long getIdMedioDePago() {return idMedioPago;}

    public void setIdMedioDePago(Long idMedioDePago) {this.idMedioPago = idMedioDePago;}

    public String getNombreMedioDePago() {return nombreMedioPago ;}

    public void setNombreMedioDePago(String nombreMedioDePago) {this.nombreMedioPago  = nombreMedioDePago;}

    public String getDescripcionMedioDePago() {return descripcionMedioPago;}

    public void setDescripcionMedioDePago(String descripcionMedioDePago) {this.descripcionMedioPago = descripcionMedioDePago;}

    @Override
    public String toString() {
        return "medioDePago{" +
                "idMedioDePago=" + idMedioPago +
                ", nombreMedioDePago='" + nombreMedioPago  + '\'' +
                ", descripcionMedioDePago='" + descripcionMedioPago + '\'' +
                '}';
    }
}
