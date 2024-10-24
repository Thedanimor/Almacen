package com.example.ProyectoAlmacen.Service;

import com.example.ProyectoAlmacen.Model.Producto;
import com.example.ProyectoAlmacen.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Guardar
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // Buscar por ID
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    // Actualizar
    public Producto update(Producto producto, Long id) {
        if(productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }
    }

    //Obtener todos los productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    //Query 1
    public List<Object[]> obtenerDescripcionesDeProductos() {
        return productoRepository.findProductDescriptions();
    }

    //Query 2
    public List<Object[]> obtenerNombrePrecioDescripcion() {
        return productoRepository.findNombrePrecioDescripcion();
    }

    //Query 3
    public List<Object[]> obtenerNombrePrecioDescripcionOrdenados() {
        return productoRepository.findNombrePrecioDescripcionOrdenados();
    }
}