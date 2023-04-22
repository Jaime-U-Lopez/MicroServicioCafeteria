package com.example.cafeteria.Repository;

import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Producto;

import java.util.Date;
import java.util.List;

public interface ProductoRepositoryDAO  {

    Producto create(ProductoDto productoDto, Date fechaIngreso, Integer stock );
    Producto Update( Producto producto);
    Boolean  delete(Integer id);
    List<Producto> getProductoAll();
    Producto getProduct(Integer id);

}
