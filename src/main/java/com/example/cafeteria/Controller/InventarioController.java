package com.example.cafeteria.Controller;


import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Service.InventarioServiceImple;
import com.example.cafeteria.Service.ProductoServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cafeteria/v1/")
public class InventarioController {

    private InventarioServiceImple inventarioServiceImple;

    @Autowired

    public InventarioController(InventarioServiceImple inventarioServiceImple) {
        this.inventarioServiceImple = inventarioServiceImple;
    }

    @PostMapping("inventarios")
    public Inventario createInventario(@RequestBody Inventario inventario){
        return this.inventarioServiceImple.registrarInventario(inventario);
    }


    @GetMapping("inventarios")
    public List<Inventario> listInventario(){
        return this.inventarioServiceImple.consultarAll();
    }

    @GetMapping("inventarios/{id}")
    public  Inventario  inventarioGet(@PathVariable Integer id){
        return this.inventarioServiceImple.consultarByID(id);
    }


    @PutMapping("inventarios")
    public Inventario updateInventario(@RequestBody Inventario inventario ){
        return this.inventarioServiceImple.actualizarInventario(inventario);
    }

    @DeleteMapping("inventarios/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        this.inventarioServiceImple.reversarInventario(id);
        String message = " El Inventario con  id "+id + " fue eliminado con exito! ";
        return  ResponseEntity.ok(message);

    }



}
