package com.example.cafeteria.Service;

import com.example.cafeteria.DTO.VentaDto;
import com.example.cafeteria.Entity.VentaProductos;

import java.util.List;

public interface CafeteriaService {


    VentaProductos registrarVenta(VentaDto ventaDto);
    void reversarVenta( Integer id);
    List<VentaProductos> consultarVentasAll();
    VentaProductos consultaByID(Integer id);
    VentaProductos actualizarVenta(VentaProductos ventaProductos);

}
