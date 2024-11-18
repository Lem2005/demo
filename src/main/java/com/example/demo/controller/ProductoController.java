package com.example.demo.controller;

import com.example.demo.dto.Producto;
import com.example.demo.services.ProductoServicesImpl;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductoController {

    @Autowired
    private ProductoServicesImpl productoServicesImpl;

    @GetMapping("/all")
    public List<Producto> getAllProductos() {
        return productoServicesImpl.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable(name = "id") String id) {
        return productoServicesImpl.getProductoById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto con id " + id + " no encontrado."));
    }

    @PostMapping("/create")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoServicesImpl.createProducto(producto);
    }

    @PutMapping("/update/{id}")
    public Producto updateProducto(@PathVariable(name = "id") String id, @RequestBody Producto producto) {
        return productoServicesImpl.updateProducto(id, producto);
    }
}