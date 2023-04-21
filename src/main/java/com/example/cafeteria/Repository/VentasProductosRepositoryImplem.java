package com.example.cafeteria.Repository;


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

        Optional<VentaProductos> ventaProductos1=  this.ventasProductosRepository.findById(ventaProductos.getId());
        if(!ventaProductos1.isEmpty()){
            throw new ExceptionCafeteria("La venta con el id "+ ventaProductos.getId() + "ya existe en la base de datos");
        }
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
        if(ventaProductos.isEmpty()){

            throw new ExceptionCafeteria(" El producto vendido con id " + id + "  no existe en la base de datos " );
        }

        return ventaProductos.get() ;
    }
}
