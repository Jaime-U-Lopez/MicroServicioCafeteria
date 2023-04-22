package com.example.cafeteria.Service;


import com.example.cafeteria.Entity.Inventario;

import java.util.List;

public interface InventarioService {

    Inventario registrarInventario(Inventario inventario );
    void reversarInventario(Integer id);
    List<Inventario> consultarAll();
    Inventario consultarByID(Integer id);

    Inventario actualizarInventario(Inventario inventario );



}
