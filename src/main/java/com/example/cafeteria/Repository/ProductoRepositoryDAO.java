package com.example.cafeteria.Repository;

import com.example.cafeteria.Entity.Producto;

import java.util.List;

public interface ProductoRepositoryDAO  {

    Producto create( Producto producto );
    Producto Update( Producto producto );
    void  delete( Integer  id  );
    List<Producto> getProductoAll();
    Producto getProduct( Integer id);

}
