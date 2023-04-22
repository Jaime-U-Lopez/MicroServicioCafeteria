package com.example.cafeteria.Service;

import com.example.cafeteria.DTO.VentaDto;
import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Entity.VentaProductos;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import com.example.cafeteria.Repository.VentasProductosRepositoryImplem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CafeteriaServiceImple implements CafeteriaService {


    private VentasProductosRepositoryImplem ventasProductosRepositoryImplem;
    private ProductoServiceImple productoServiceImple;
    private InventarioServiceImple inventarioServiceImple;


    @Autowired
    public CafeteriaServiceImple(InventarioServiceImple inventarioServiceImple, ProductoServiceImple productoServiceImple, VentasProductosRepositoryImplem ventasProductosRepositoryImplem) {
        this.ventasProductosRepositoryImplem = ventasProductosRepositoryImplem;
        this.productoServiceImple =productoServiceImple;
        this.inventarioServiceImple = inventarioServiceImple;
    }
    @Override
    public ResponseEntity<?> registrarVenta(VentaDto ventaDto) throws RuntimeException{
    Integer idProducto= ventaDto.getIdProducto();
    Integer cantidad=ventaDto.getCantidad();

    Optional<Producto> productoOptional=Optional.of(this.productoServiceImple.getProducto(idProducto));
    if(cantidad<=0){
        throw new ExceptionCafeteria(" La cantidad ingresada :" + cantidad +" no puede ser menor a cero o igual a cero"  );
    }
    if(!productoOptional.isPresent()){
        throw new ExceptionCafeteria(" El producto con id :" + idProducto +" no existe en la base de datos"  );
    }

    Integer stockActual=productoOptional.get().getStock();
    if(stockActual>= cantidad ){
        String salida= "venta";
        Integer stockActualizado= stockActual-cantidad;
        productoOptional.get().setStock(stockActualizado);
       Producto productoUpdate=  this.productoServiceImple.UpdateProducto(productoOptional.get());
       Inventario inventarioUpdate= new Inventario(productoUpdate,salida);

        this.inventarioServiceImple.registrarInventario(inventarioUpdate);
        VentaProductos ventaProductos= new VentaProductos(productoUpdate, cantidad);

        this.ventasProductosRepositoryImplem.create(ventaProductos);
    }else{
        throw new ExceptionCafeteria("No es posible realizar la venta, la cantidad  " + cantidad+ " supera el stock actual :" +stockActual);
    }

    String message= "Producto con id : " + idProducto + "  vendido con exito ¡¡ ";

    return ResponseEntity.ok(message);

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

    @Override
    public Producto consultaProductoConMasStock() {
        return this.ventasProductosRepositoryImplem.queryzProductoConMasStock();
    }
}
