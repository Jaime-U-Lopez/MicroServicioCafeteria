package com.example.cafeteria.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Producto producto;
    private Integer StockProducto;
    private Date fechaUltimoRegistro;

    public Inventario(Producto producto, Integer stockProducto, Date fechaUltimoRegistro) {
        this.producto = producto;
        StockProducto = stockProducto;
        this.fechaUltimoRegistro = fechaUltimoRegistro;
    }

    public Inventario() {
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

    public Integer getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(Integer stockProducto) {
        StockProducto = stockProducto;
    }

    public Date getFechaUltimoRegistro() {
        return fechaUltimoRegistro;
    }

    public void setFechaUltimoRegistro(Date fechaUltimoRegistro) {
        this.fechaUltimoRegistro = fechaUltimoRegistro;
    }
}
