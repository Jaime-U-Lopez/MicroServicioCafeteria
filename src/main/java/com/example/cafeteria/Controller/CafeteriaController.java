package com.example.cafeteria.Controller;


import com.example.cafeteria.DTO.VentaDto;
import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.VentaProductos;
import com.example.cafeteria.Service.CafeteriaService;
import com.example.cafeteria.Service.CafeteriaServiceImple;
import com.example.cafeteria.Service.InventarioServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("cafeteria/v1/")
public class CafeteriaController {

    private CafeteriaServiceImple cafeteriaServiceImple;

    @Autowired
    public CafeteriaController(CafeteriaServiceImple cafeteriaServiceImple) {
        this.cafeteriaServiceImple = cafeteriaServiceImple ;
    }

    @PostMapping("ventas")
    public VentaProductos createVenta(VentaDto ventaDto ){

        return this.cafeteriaServiceImple.registrarVenta(ventaDto);
    }


    @GetMapping("ventas")
    public List<VentaProductos> listVentas(){
        return this.cafeteriaServiceImple.consultarVentasAll();
    }

    @GetMapping("ventas/{id}")
    public  VentaProductos  ventaGet(@PathVariable Integer id){
        return this.cafeteriaServiceImple.consultaByID(id);
    }


    @PutMapping("ventas")
    public VentaProductos updateVenta(@RequestBody VentaProductos ventaProductos  ){
        return this.cafeteriaServiceImple.actualizarVenta(ventaProductos);
    }

    @DeleteMapping("ventas/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        this.cafeteriaServiceImple.reversarVenta(id);
        String message = " La venta con id "+id + " fue eliminado con exito! ";
        return  ResponseEntity.ok(message);

    }



}
