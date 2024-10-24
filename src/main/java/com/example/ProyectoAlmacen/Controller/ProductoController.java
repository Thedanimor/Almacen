package com.example.ProyectoAlmacen.Controller;

import com.example.ProyectoAlmacen.Model.Producto;
import com.example.ProyectoAlmacen.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Crear producto
    @PostMapping("/guardar")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto productoGuardado = productoService.save(producto);
        return ResponseEntity.ok(productoGuardado);
    }

    // Buscar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        if (productoOpt.isPresent()) {
            return ResponseEntity.ok(productoOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto, @PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        if (productoOpt.isPresent()) {
            // Si el producto existe, actualizamos los valores
            Producto productoExistente = productoOpt.get();
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setDetalleProducto(producto.getDetalleProducto());
            Producto updatedProducto = productoService.save(productoExistente);
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        if (productoOpt.isPresent()) {
            productoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.findAll();
        if (!productos.isEmpty()) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/descripciones")
    public ResponseEntity<List<Object[]>> obtenerDescripciones() {
        List<Object[]> descripciones = productoService.obtenerDescripcionesDeProductos();
        return ResponseEntity.ok(descripciones);
    }

    @GetMapping("/detalles")
    public ResponseEntity<List<Object[]>> obtenerDetalles() {
        List<Object[]> detalles = productoService.obtenerNombrePrecioDescripcion();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/detalles-ordenados")
    public ResponseEntity<List<Object[]>> obtenerDetallesOrdenados() {
        List<Object[]> detalles = productoService.obtenerNombrePrecioDescripcionOrdenados();
        return ResponseEntity.ok(detalles);
    }

}