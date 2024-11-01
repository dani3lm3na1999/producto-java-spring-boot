package com.proyecto.producto_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.producto_api.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
