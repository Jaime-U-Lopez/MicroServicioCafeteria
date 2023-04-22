package com.example.cafeteria.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class VentaProductos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;
    private Integer cantidadVendida;

    public VentaProductos(Producto producto, Integer cantidadVendida) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
