package com.example.cafeteria.Service;

import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Repository.InventarioRepository;
import com.example.cafeteria.Repository.ProductoRepository;
import com.example.cafeteria.Repository.ProductoRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImple  implements ProductoService {


    private ProductoRepositoryImple productoRepositoryImple;
    private ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImple(ProductoRepository productoRepository,ProductoRepositoryImple productoRepositoryImple) {
        this.productoRepositoryImple = productoRepositoryImple;
        this.productoRepository=productoRepository;
    }

    @Override
    public Producto createProducto(ProductoDto productoDto) {
        LocalDate fechaActual = LocalDate.now();
        Date fechaIngreso= Date.valueOf(fechaActual);
        Integer stock= 1;

        Integer id = productoDto.getId();
        Optional<Producto> productoOptional= this.productoRepository.findById(id);
        if(productoOptional.isPresent()){
            Integer stockActual= productoOptional.get().getStock();
            productoOptional.get().setStock(stockActual+stock);
            this.productoRepository.save(productoOptional.get());
            return  productoOptional.get();
        }else {
            return this.productoRepositoryImple.create(productoDto ,fechaIngreso , stock);

        }






    }

    @Override
    public Producto UpdateProducto(Producto producto) {
        return this.productoRepositoryImple.Update(producto);
    }

    @Override
    public void deleteProducto(Integer id) {
        this.productoRepositoryImple.delete(id);
    }


    @Override
    public List<Producto> getProductoAll() {
        return this.productoRepositoryImple.getProductoAll();
    }

    @Override
    public Producto getProducto(Integer id) throws RuntimeException {
        return this.productoRepositoryImple.getProduct(id);
    }
}
