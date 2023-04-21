package com.example.cafeteria.Repository;


import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Entity.VentaProductos;

import java.util.List;

public interface VentasProductosRepositoryDao  {

    VentaProductos create(VentaProductos ventaProductos );
    VentaProductos Update( VentaProductos ventaProductos );
    void  delete( Integer  id  );
    List<VentaProductos> getVentaProductoAll();
    VentaProductos getVentaProduct( Integer id);

}
