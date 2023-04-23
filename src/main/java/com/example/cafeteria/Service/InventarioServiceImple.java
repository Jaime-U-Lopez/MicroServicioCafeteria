package com.example.cafeteria.Service;

import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Repository.InventarioRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Inventario registrarInventario(Inventario inventario) {
        return this.inventarioRepositoryImple.create(inventario);
    }

    @Override
    @Transactional
    public void reversarInventario(Integer id) {
        this.inventarioRepositoryImple.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventario> consultarAll() {
        return this.inventarioRepositoryImple.getInventarioAll();
    }

    @Override
    @Transactional
    public Inventario consultarByID(Integer id) {
        return this.inventarioRepositoryImple.getInventario(id);

    }

    @Override
    @Transactional
    public Inventario actualizarInventario(Inventario inventario) {
        return this.inventarioRepositoryImple.Update(inventario);
    }


}
