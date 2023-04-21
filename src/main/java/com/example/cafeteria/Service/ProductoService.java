package com.example.cafeteria.Service;

import com.example.cafeteria.Entity.Producto;

import java.util.List;

public interface ProductoService  {


    Producto createProducto(Producto producto);
    Producto UpdateProducto( Producto producto );
    void  deleteProducto( Integer  id  );
    List<Producto> getProductoAll();
    Producto getProduct( Integer id);
}
