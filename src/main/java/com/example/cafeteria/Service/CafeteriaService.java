package com.example.cafeteria.Service;

import com.example.cafeteria.Entity.VentaProductos;

import java.util.List;

public interface CafeteriaService {


    VentaProductos registrarVenta(Integer idProducto, Integer cantidad);
    void reversarVenta( Integer id);
    List<VentaProductos> consultarVentasAll();
    VentaProductos consultaByID(Integer id);

}
