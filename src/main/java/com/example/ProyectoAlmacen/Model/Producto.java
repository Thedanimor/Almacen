package com.example.ProyectoAlmacen.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double precio;

    @OneToOne(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private DetalleProducto detalleProducto;

    public Producto() {}

    public Producto(Long id, String nombre, Double precio, DetalleProducto detalleProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.detalleProducto = detalleProducto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
        if (detalleProducto != null) {
            detalleProducto.setProducto(this);
        }
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", detalleProducto=" + detalleProducto + "]";
    }
}
