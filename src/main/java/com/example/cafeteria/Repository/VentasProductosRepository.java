package com.example.cafeteria.Repository;

import com.example.cafeteria.Entity.Producto;
import com.example.cafeteria.Entity.VentaProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VentasProductosRepository extends JpaRepository<VentaProductos,Integer> {


    @Query("select p from Producto p Order by p.stock Desc ")
    Producto productoConMasStock();

   // TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p ORDER BY p.stock DESC", Producto.class);
    //Producto productoConMayorStock = query.setMaxResults(1).getSingleResult();

   // @Query("  "  )
    //VentaProductos productoMasVendido();



}
