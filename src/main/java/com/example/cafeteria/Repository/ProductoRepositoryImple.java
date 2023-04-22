package com.example.cafeteria.Repository;

import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import com.example.cafeteria.Service.InventarioServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositoryImple  implements ProductoRepositoryDAO {

    private  ProductoRepository productoRepository;
    private InventarioServiceImple inventarioServiceImple;

    @Autowired
    public ProductoRepositoryImple(ProductoRepository productoRepository, InventarioServiceImple inventarioServiceImple) {
        this.productoRepository = productoRepository;
        this.inventarioServiceImple= inventarioServiceImple;

    }

    public ProductoRepositoryImple() {

    }

    @Override
    public Producto create(ProductoDto productoDto, Date fechaIngreso, Integer stock) throws RuntimeException  {

        String categoria= productoDto.getCategoria();
        String nombreProducto= productoDto.getNombreProducto();
        Integer peso= productoDto.getPeso();
        String referencia= productoDto.getReferencia();
        Integer precio= productoDto.getPrecio();
        Integer id=productoDto.getId();

        Producto producto = new Producto(id,nombreProducto,referencia,precio,peso,categoria,stock,fechaIngreso);
        this.productoRepository.save(producto);
        Optional<Producto> productoOptional= this.productoRepository.findById(id);
        String tipo="ingreso";
        Inventario inventario= new Inventario(productoOptional.get(), tipo);
        this.inventarioServiceImple.registrarInventario(inventario)    ;

    return productoOptional.get();

    }

    @Override
    public Producto Update(Producto producto) {

        return this.productoRepository.saveAndFlush(producto);
    }

    @Override
    public Boolean delete(Integer id)  {

            this.productoRepository.deleteById(id);
              return true;
    }

    @Override
    public List<Producto> getProductoAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto getProduct(Integer id) throws RuntimeException {

        Optional<Producto> producto= this.productoRepository.findById(id);
        if (!producto.isPresent()){
            throw new ExceptionCafeteria("El Producto con id " + id + " no se encuentra en la base de datos");
        }
        return producto.get() ;
    }
}
