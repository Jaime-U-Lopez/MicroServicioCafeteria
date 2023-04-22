package com.example.cafeteria.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Inventario  implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false)

    private Integer id;
    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

    private String tipo;


    public Inventario() {
    }

    public Inventario(Producto producto, String tipo) {
        this.producto = producto;
        this.tipo=tipo;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
