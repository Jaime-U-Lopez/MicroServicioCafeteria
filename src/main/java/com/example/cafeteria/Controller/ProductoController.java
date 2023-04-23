package com.example.cafeteria.Controller;


import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Service.ProductoServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cafeteria/v1/")
public class ProductoController {

    private ProductoServiceImple productoServiceImple;

    @Autowired
    public ProductoController(ProductoServiceImple productoServiceImple) {
        this.productoServiceImple = productoServiceImple;
    }


    @PostMapping("productos")
    public Producto  createProduct(@RequestBody ProductoDto  productoDto){
        return this.productoServiceImple.createProducto(productoDto);
    }

    @GetMapping("productos")
    public List<Producto> listProduct(){
        return this.productoServiceImple.getProductoAll();
    }

    @GetMapping("productos/{id}")
    public  Producto  productoGet(@PathVariable Integer id){
        return this.productoServiceImple.getProducto(id);
    }

    @PutMapping("productos")
    public Producto updateProduct(@RequestBody Producto producto){
        return this.productoServiceImple.UpdateProducto(producto);
    }

    @DeleteMapping("productos/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){

        Boolean deleted = this.productoServiceImple.deleteProducto(id);
        if (deleted) {
            String messaje = "El producto  con id :  " + id + " fue eliminado con exito!";
            return ResponseEntity.ok(messaje);
        } else {
            String messaje = "El producto   con id   " + id + " no fue eliminado, valide el numero de guia ingresado no si exista en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }
    }



    }




