package com.example.cafeteria.Service;

import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Producto;

import java.util.List;

public interface ProductoService  {


    Producto createProducto(ProductoDto productoDto);
    Producto UpdateProducto( Producto producto );
    void  deleteProducto( Integer  id  );
    List<Producto> getProductoAll();
    Producto getProducto( Integer id);
}
