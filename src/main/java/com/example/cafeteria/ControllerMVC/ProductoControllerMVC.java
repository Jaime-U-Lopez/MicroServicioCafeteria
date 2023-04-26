package com.example.cafeteria.ControllerMVC;


import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import com.example.cafeteria.Service.ProductoServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductoControllerMVC {


    private ProductoServiceImple productoServiceImple;


    @Autowired
    public ProductoControllerMVC(ProductoServiceImple productoServiceImple) {
        this.productoServiceImple = productoServiceImple;
    }



    @GetMapping("/producto")
    public String producto(Model model){
        List<Producto> productos = productoServiceImple.getProductoAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @PostMapping("/eliminarProducto")
    public String eliminarProducto(@RequestParam("id") Integer id ) {

        if (id == null) {
            throw new ExceptionCafeteria("hay un error  campos null id : " + id);
        }
        try {
            productoServiceImple.deleteProducto(id);
        }catch (Exception e){

            throw new ExceptionCafeteria("No se pudo eliminar, ya que es una llave foranea que se usa en otras tablas");
        }

        return "redirect:/";

    }

    @PostMapping("/producto/agregar")
    public String guardarProducto(ProductoDto productoDto){

        if(productoDto.getCategoria().equals(null)
                || productoDto.getNombreProducto().equals(null)
                || productoDto.getReferencia().equals(null)
                || productoDto.getPrecio() == 0
                || productoDto.getPeso() == 0){
            throw new ExceptionCafeteria(" Alguno de los campos esta vacio, por favor completelo");

        }

        productoServiceImple.createProducto(productoDto);
        return "redirect:/";
    }

}
