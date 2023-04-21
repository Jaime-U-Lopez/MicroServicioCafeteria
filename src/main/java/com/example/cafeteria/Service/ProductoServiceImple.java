package com.example.cafeteria.Service;

import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Repository.ProductoRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImple  implements ProductoService {


    private ProductoRepositoryImple productoRepositoryImple;

    @Autowired
    public ProductoServiceImple(ProductoRepositoryImple productoRepositoryImple) {
        this.productoRepositoryImple = productoRepositoryImple;
    }

    @Override
    public Producto createProducto(Producto producto) {
        return this.productoRepositoryImple.create(producto);
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
    public Producto getProduct(Integer id) throws RuntimeException {
        return this.productoRepositoryImple.getProduct(id);
    }
}
