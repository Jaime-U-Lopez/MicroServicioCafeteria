package com.example.cafeteria.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class VentaProductos implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer contador=0;

    @Id
    private Integer idVenta;
    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

    private Integer cantidadVendida;


    public VentaProductos() {
    }

    public VentaProductos( Producto producto, Integer cantidadVendida) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.idVenta=VentaProductos.contador++;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
