package com.example.cafeteria.Service;

import com.example.cafeteria.Entity.VentaProductos;
import com.example.cafeteria.Repository.VentasProductosRepositoryImplem;

import java.util.List;

public class CafeteriaServiceImple implements CafeteriaService {


    private VentasProductosRepositoryImplem ventasProductosRepositoryImplem;


    public CafeteriaServiceImple(VentasProductosRepositoryImplem ventasProductosRepositoryImplem) {
        this.ventasProductosRepositoryImplem = ventasProductosRepositoryImplem;
    }

    @Override
    public VentaProductos registrarVenta(Integer idProducto, Integer cantidad) {
        return null;
    }

    @Override
    public void reversarVenta(Integer id) {
        this.ventasProductosRepositoryImplem.delete(id);

    }

    @Override
    public List<VentaProductos> consultarVentasAll() {
        return this.ventasProductosRepositoryImplem.getVentaProductoAll();
    }

    @Override
    public VentaProductos consultaByID(Integer id) {
        return this.ventasProductosRepositoryImplem.getVentaProduct(id);
    }
}
