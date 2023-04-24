package com.example.cafeteria.ControllerMVC;


import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.DTO.VentaDto;
import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Entity.VentaProductos;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import com.example.cafeteria.Service.CafeteriaServiceImple;
import com.example.cafeteria.Service.InventarioServiceImple;
import com.example.cafeteria.Service.ProductoServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class CafeteriaControllerMVC {

    private CafeteriaServiceImple cafeteriaServiceImple;
    private ProductoServiceImple productoServiceImple;
    private InventarioServiceImple inventarioServiceImple;
    @Autowired
    public CafeteriaControllerMVC(InventarioServiceImple inventarioServiceImple,  CafeteriaServiceImple cafeteriaServiceImple, ProductoServiceImple productoServiceImple) {
        this.cafeteriaServiceImple = cafeteriaServiceImple ;
        this.productoServiceImple= productoServiceImple;
        this.inventarioServiceImple= inventarioServiceImple;

    }


    @GetMapping("/")
    public String inicio(Model model){
        List<VentaProductos> ventas = cafeteriaServiceImple.consultarVentasAll();
        List<Producto> productos = productoServiceImple.getProductoAll();
        model.addAttribute("ventas", ventas);
        model.addAttribute("productos", productos);
        return "inicio";
    }

    @GetMapping("/venta")
    public String venta(Model model){
        List<VentaProductos> ventas = cafeteriaServiceImple.consultarVentasAll();
        List<Producto> productos = productoServiceImple.getProductoAll();
        model.addAttribute("ventas", ventas);
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/producto")
    public String producto(Model model){
        List<Producto> productos = productoServiceImple.getProductoAll();
        model.addAttribute("productos", productos);
        return "producto";
    }



    @GetMapping("/inventario")
    public String inventario(Model model){
        List<Inventario> inventarios = inventarioServiceImple.consultarAll();
        model.addAttribute("inventarios", inventarios);
        return "inventario";
    }

    @PostMapping("/guardarVenta")
    public String guardarVenta(@ModelAttribute("ventaDto") VentaDto ventaDto, BindingResult bindingResult) {

        if (ventaDto.getIdProducto() == null || ventaDto.getCantidad() == null) {
        throw new ExceptionCafeteria("hay un error  campos null" + ventaDto.getIdProducto() +  ventaDto.getCantidad() );
        }
        cafeteriaServiceImple.registrarVenta(ventaDto);

        return "redirect:/";
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



    @PostMapping("/eliminarVenta")
    public String eliminarVenta(@RequestParam("idVenta") Integer idVenta ) {

        if (idVenta == null) {
            throw new ExceptionCafeteria("hay un error  campos null id : " + idVenta);
        }
        cafeteriaServiceImple.reversarVenta(idVenta);
        System.out.println("Producto ID: " + idVenta);
        return "redirect:/";

    }

        @GetMapping("/agregar")
    public String producto(VentaDto ventaDto){
        return "producto";
    }

    @PostMapping("/guardarrr")
    public String guardar(VentaDto ventaDto){
        cafeteriaServiceImple.registrarVenta(ventaDto);
        return "redirect:/";
    }

    @PostMapping("/producto/agregar")
    public String guardarProducto(ProductoDto productoDto){
        productoServiceImple.createProducto(productoDto);
        return "redirect:/";
    }















    @GetMapping("/p")
    public String index(Model model) {

        String mensaje = "hola mundo";
        List<VentaProductos> ventas = this.cafeteriaServiceImple.consultarVentasAll();
        model.addAttribute("ventas", ventas);
        model.addAttribute("mensaje", mensaje);

        return "index";
    }
    @GetMapping("/venta/nuevo")
    public String formularioNuevoProducto(Model model) {

        model.addAttribute("producto", new Producto());
        return "formulario";
    }




}
