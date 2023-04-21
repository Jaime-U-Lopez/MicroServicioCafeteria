package com.example.cafeteria.Repository;


import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InventarioRepositoryImple implements InventarioRepositoryDao{

    private InventarioRepository inventarioRepository;

    @Autowired
    public InventarioRepositoryImple(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public Inventario create(Inventario inventario) {
        return this.inventarioRepository.save(inventario);
    }

    @Override
    public Inventario Update(Inventario inventario) {
        return this.inventarioRepository.saveAndFlush(inventario);
    }

    @Override
    public void delete(Integer id) {
        this.getInventario(id);
        this.inventarioRepository.deleteById(id);
    }

    @Override
    public List<Inventario> getInventarioAll() {
        return this.inventarioRepository.findAll();
    }

    @Override
    public Inventario getInventario(Integer id) {

        Optional<Inventario> inventario= this.inventarioRepository.findById(id);
        if (inventario.isEmpty()){
            throw new ExceptionCafeteria("El Inventario  con id " + id + " no se encuentra en la base de datos");
        }
        return inventario.get() ;
    }
}
