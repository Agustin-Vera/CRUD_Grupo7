package com.example.ProyectoDBDGrupo7.models;
import java.util.Date;

public class boletadecompra {
    private long IdBoletadeCompra;
    private Date FechaBoleta;
    private int MontoBoleta;
    private Integer IdCarro;
    private Integer IdMedioPago;

    public boletadecompra(long IdBoletadeCompra, Date FechaBoleta, int MontoBoleta, Integer IdCarro, Integer IdMedioPago) {
        this.IdBoletadeCompra = IdBoletadeCompra;
        this.FechaBoleta = FechaBoleta;
        this.MontoBoleta = MontoBoleta;
        this.IdCarro = IdCarro;
        this.IdMedioPago = IdMedioPago;
    }

    public long getIdBoletadeCompra() {return IdBoletadeCompra;}
    public void setIdBoletadeCompra(long IdBoletadeCompra) { this.IdBoletadeCompra = IdBoletadeCompra;}

    public Date getFechaBoleta() {return FechaBoleta;}
    public void setFechaBoleta( Date FechaBoleta) { this.FechaBoleta = FechaBoleta;}

    public int getMontoBoleta() {return MontoBoleta;}
    public void setMontoBoleta(int montoBoleta) {this.MontoBoleta = MontoBoleta;}

    public Integer getIdCarro() {return IdCarro;}
    public void setIdCarro(Integer IdCarro) {this.IdCarro = IdCarro;}

    public Integer getIdMedioPago() {return IdMedioPago;}
    public void setIdMedioPago(Integer idMedioPago) {this.IdMedioPago = idMedioPago;}

    @Override

    public String toString() {
        return "boleta{" +
                "IdBoletadeCompra=" + IdBoletadeCompra +
                ", FechaBoleta=" + FechaBoleta +
                ", MontoBoleta=" + MontoBoleta +
                ", IdCarro=" + IdCarro +
                ", IdMedioPago=" + IdMedioPago +
                "}";
    }
}
