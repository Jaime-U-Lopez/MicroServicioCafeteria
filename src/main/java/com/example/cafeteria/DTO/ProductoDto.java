package com.example.cafeteria.DTO;

import javax.persistence.Column;

public class ProductoDto {


    private Integer id;
    private String nombreProducto;
    private String categoria;
    private String referencia;
    private Integer peso;
    private Integer precio;



    public ProductoDto(Integer id, String nombreProducto, String categoria, String referencia, Integer peso, Integer precio) {
        this.id=id;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.referencia = referencia;
        this.peso = peso;
        this.precio = precio;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer  precio) {
        this.precio = precio;
    }
}
