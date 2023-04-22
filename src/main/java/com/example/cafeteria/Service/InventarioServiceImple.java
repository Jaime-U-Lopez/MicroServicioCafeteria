package com.example.cafeteria.Service;

import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Repository.InventarioRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImple implements InventarioService {


    private InventarioRepositoryImple inventarioRepositoryImple;

@Autowired
    public InventarioServiceImple(InventarioRepositoryImple inventarioRepositoryImple) {
        this.inventarioRepositoryImple = inventarioRepositoryImple;
    }

    public InventarioServiceImple() {
    }

    @Override
    public Inventario registrarInventario(Inventario inventario) {
        return this.inventarioRepositoryImple.create(inventario);
    }

    @Override
    public void reversarInventario(Integer id) {
        this.inventarioRepositoryImple.delete(id);
    }

    @Override
    public List<Inventario> consultarAll() {
        return this.inventarioRepositoryImple.getInventarioAll();
    }

    @Override
    public Inventario consultarByID(Integer id) {
        return this.inventarioRepositoryImple.getInventario(id);

    }

    @Override
    public Inventario actualizarInventario(Inventario inventario) {
        return this.inventarioRepositoryImple.Update(inventario);
    }


}
