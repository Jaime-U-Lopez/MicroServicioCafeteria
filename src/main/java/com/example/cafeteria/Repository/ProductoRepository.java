package com.example.cafeteria.Repository;

import com.example.cafeteria.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto, Integer> {


}
