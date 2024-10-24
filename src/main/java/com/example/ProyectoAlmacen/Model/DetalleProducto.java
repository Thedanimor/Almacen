package com.example.ProyectoAlmacen.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private String caracteristica;

    @OneToOne
    @JoinColumn(name = "producto_id")
    @JsonBackReference
    private Producto producto;

    public DetalleProducto() {}

    public DetalleProducto(Long id, String descripcion, String caracteristica, Producto producto) {
        this.id = id;
        this.descripcion = descripcion;
        this.caracteristica = caracteristica;
        this.producto = producto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleProducto [id=" + id +
                ", descripcion=" + descripcion +
                ", caracteristica=" + caracteristica +
                ", producto=" + producto + "]";
    }
}
