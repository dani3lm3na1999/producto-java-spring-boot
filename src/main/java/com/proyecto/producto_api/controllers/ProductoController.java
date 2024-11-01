package com.proyecto.producto_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.producto_api.models.Producto;
import com.proyecto.producto_api.repositories.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    // Crear nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    // Tomar todos los productos
    @GetMapping
    public List<Producto> obtenerTodosProductos(){
        return productoRepository.findAll();
    }

    // Tomar todos los productos por Id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id){
        return productoRepository.findById(id)
                .map(producto -> ResponseEntity.ok().body(producto))
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un Producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        return productoRepository.findById(id)
                .map(product -> {
                    product.setName(producto.getName());
                    product.setDescripcion(producto.getDescripcion());
                    product.setPrice(producto.getPrice());
                    Producto updateProducto = productoRepository.save(producto);
                    return ResponseEntity.ok().body(updateProducto);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un Producto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        return productoRepository.findById(id)
                .map(producto -> {
                    productoRepository.delete(producto);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
