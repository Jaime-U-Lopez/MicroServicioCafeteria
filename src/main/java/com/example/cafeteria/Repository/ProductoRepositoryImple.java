package com.example.cafeteria.Repository;

import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositoryImple  implements ProductoRepositoryDAO {

    private  ProductoRepository productoRepository;

    @Autowired
    public ProductoRepositoryImple(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ProductoRepositoryImple() {

    }

    @Override
    public Producto create(Producto producto) {

        return this.productoRepository.save(producto);
    }

    @Override
    public Producto Update(Producto producto) {

        return this.productoRepository.saveAndFlush(producto);
    }

    @Override
    public void delete(Integer id) {

        this.getProduct(id);
        this.productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> getProductoAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto getProduct(Integer id) throws RuntimeException {

        Optional<Producto> producto= this.productoRepository.findById(id);
        if (producto.isEmpty()){
            throw new ExceptionCafeteria("El Producto con id " + id + " no se encuentra en la base de datos");
        }
        return producto.get() ;
    }
}
