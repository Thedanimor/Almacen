package com.example.ProyectoAlmacen.Controller;

import com.example.ProyectoAlmacen.Model.DetalleProducto;
import com.example.ProyectoAlmacen.Model.Producto;
import com.example.ProyectoAlmacen.Service.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detallesopcional")
public class DetalleProductoController {

    @Autowired
    private DetalleProductoService detalleProductoService;
}
