package com.example.cafeteria.ControllerMVC;


import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Service.InventarioServiceImple;
import com.example.cafeteria.Service.ProductoServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InventarioControllerMVC {


    private InventarioServiceImple inventarioServiceImple;


    @Autowired
    public InventarioControllerMVC(InventarioServiceImple inventarioServiceImple) {
        this.inventarioServiceImple = inventarioServiceImple;
    }


    @GetMapping("/inventario")
    public String inventario(Model model){
        List<Inventario> inventarios = inventarioServiceImple.consultarAll();
        model.addAttribute("inventarios", inventarios);
        return "inventario";
    }


}
