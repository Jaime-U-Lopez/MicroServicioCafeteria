package com.example.cafeteria.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Producto  implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String  nombreProducto;
    @Column(nullable = false)
    private String  referencia;
    @Column(nullable = false)
    private Integer  precio;
    @Column(nullable = false)
    private Integer  peso;
    @Column(nullable = false)
    private String  categoria;
    @Column(nullable = false)
    private Integer  Stock;
    @Column(nullable = false)
    private Date fechaCreacion;
    @OneToMany
    private List<Producto> inventario;

    public Producto() {
    }

    public Producto(String nombreProducto, String referencia, Integer precio, Integer peso, String categoria, Integer stock, Date fechaCreacion) {
        this.nombreProducto = nombreProducto;
        this.referencia = referencia;
        this.precio = precio;
        this.peso = peso;
        this.categoria = categoria;
        Stock = stock;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
