package com.example.cafeteria.Repository;


import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Entity.VentaProductos;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VentasProductosRepositoryImplem implements VentasProductosRepositoryDao {

    private VentasProductosRepository ventasProductosRepository;

    @Autowired
    public VentasProductosRepositoryImplem(VentasProductosRepository ventasProductosRepository) {
        this.ventasProductosRepository = ventasProductosRepository;
    }


    @Override
    public VentaProductos create(VentaProductos ventaProductos) throws RuntimeException {

        return this.ventasProductosRepository.save(ventaProductos);
    }

    @Override
    public VentaProductos Update(VentaProductos ventaProductos) {
        return this.ventasProductosRepository.saveAndFlush(ventaProductos);
    }

    @Override
    public void delete(Integer id) {

        this.getVentaProduct(id);
        this.ventasProductosRepository.deleteById(id);
    }

    @Override
    public List<VentaProductos> getVentaProductoAll() {
        return this.ventasProductosRepository.findAll();
    }

    @Override
    public VentaProductos getVentaProduct(Integer id) throws RuntimeException {

        Optional<VentaProductos> ventaProductos= this.ventasProductosRepository.findById(id);
        if(!ventaProductos.isPresent()){

            throw new ExceptionCafeteria(" La Venta con  id " + id + "  no existe en la base de datos " );
        }
        return ventaProductos.get() ;
    }

    @Override
    public Producto queryzProductoConMasStock() {
        return this.ventasProductosRepository.productoConMasStock();
    }
}
