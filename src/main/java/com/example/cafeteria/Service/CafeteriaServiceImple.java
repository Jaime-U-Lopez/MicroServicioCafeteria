package com.example.cafeteria.Service;

import com.example.cafeteria.DTO.VentaDto;
import com.example.cafeteria.Entity.VentaProductos;
import com.example.cafeteria.Repository.VentasProductosRepositoryImplem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CafeteriaServiceImple implements CafeteriaService {


    private VentasProductosRepositoryImplem ventasProductosRepositoryImplem;


@Autowired
    public CafeteriaServiceImple(VentasProductosRepositoryImplem ventasProductosRepositoryImplem) {
        this.ventasProductosRepositoryImplem = ventasProductosRepositoryImplem;
    }

    @Override
    public VentaProductos registrarVenta(VentaDto ventaDto) {
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

    @Override
    public VentaProductos actualizarVenta(VentaProductos ventaProductos) {
        return this.ventasProductosRepositoryImplem.Update(ventaProductos);
    }
}
