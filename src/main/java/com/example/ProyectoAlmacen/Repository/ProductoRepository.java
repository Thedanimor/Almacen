package com.example.ProyectoAlmacen.Repository;

import com.example.ProyectoAlmacen.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    @Query("SELECT p.id, d.descripcion " +
            "FROM Producto p " +
            "INNER JOIN DetalleProducto d ON p.id = d.producto.id")
    List<Object[]> findProductDescriptions();

    @Query("SELECT p.nombre, p.precio, d.descripcion " +
            "FROM Producto p " +
            "INNER JOIN p.detalleProducto d")
    List<Object[]> findNombrePrecioDescripcion();

    @Query("SELECT p.nombre, p.precio, d.descripcion " +
            "FROM Producto p " +
            "INNER JOIN DetalleProducto d ON p.id = d.producto.id " +
            "ORDER BY p.precio ASC")
    List<Object[]> findNombrePrecioDescripcionOrdenados();

}
