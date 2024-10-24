package com.example.ProyectoAlmacen.Service;

import com.example.ProyectoAlmacen.Model.DetalleProducto;
import com.example.ProyectoAlmacen.Repository.DetalleProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleProductoService {

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

}
