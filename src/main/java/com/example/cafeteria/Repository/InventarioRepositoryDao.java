package com.example.cafeteria.Repository;

import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;

import java.util.List;

public interface InventarioRepositoryDao {

    Inventario create(Inventario inventario );
    Inventario Update( Inventario inventario );
    void  delete( Integer  id  );
    List<Inventario> getInventarioAll();
    Inventario getInventario( Integer id);
}
