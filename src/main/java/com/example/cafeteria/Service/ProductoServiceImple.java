package com.example.cafeteria.Service;

import com.example.cafeteria.DTO.ProductoDto;
import com.example.cafeteria.Entity.Inventario;
import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Exception.ExceptionCafeteria;
import com.example.cafeteria.Repository.InventarioRepository;
import com.example.cafeteria.Repository.ProductoRepository;
import com.example.cafeteria.Repository.ProductoRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Producto createProducto(ProductoDto productoDto) throws RuntimeException {

        String nombreProducto=productoDto.getNombreProducto();
        String categoria= productoDto.getCategoria();
        String referencia=productoDto.getReferencia();
        Integer peso=productoDto.getPeso();
        Integer precio=productoDto.getPrecio();

        ProductoDto.validacionAtributos(nombreProducto,categoria,referencia,peso,precio);

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
    @Transactional
    public Producto UpdateProducto(Producto producto) throws RuntimeException {

        String nombreProducto=producto.getNombreProducto();
        String categoria= producto.getCategoria();
        String referencia=producto.getReferencia();
        Integer peso=producto.getPrecio();
        Integer precio=producto.getPrecio();

        ProductoDto.validacionAtributos(nombreProducto,categoria,referencia,peso,precio);


        return this.productoRepositoryImple.Update(producto);
    }

    @Override
    @Transactional
    public Boolean deleteProducto(Integer id) throws RuntimeException {



    try {
        this.getProducto(id);
        Optional<Boolean> producto = Optional.ofNullable(this.productoRepositoryImple.delete(id));
    if (!producto.isPresent()) {
        throw new ExceptionCafeteria("El producto con id : "+ id  + " no se pudo eliminar ");
    }
        return true;
    }catch (ExceptionCafeteria e){

    throw new ExceptionCafeteria("El producto con id : "+ id  + " no se pudo eliminar ");

}

    }


    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductoAll() {
        return this.productoRepositoryImple.getProductoAll();
    }

    @Override
    @Transactional
    public Producto getProducto(Integer id) throws RuntimeException {
        return this.productoRepositoryImple.getProduct(id);
    }
}
