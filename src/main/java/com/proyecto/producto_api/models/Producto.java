package com.proyecto.producto_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Genera getters, setters, equals, hascCode y toString
@NoArgsConstructor // genera un constructor vacio
@AllArgsConstructor // genera constructor con todos los atributos
public class Producto {
    // Propiedades
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String descripcion;
    private Double price;
}
