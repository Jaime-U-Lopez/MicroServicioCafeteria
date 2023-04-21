package com.example.cafeteria.Repository;

import com.example.cafeteria.Entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}
