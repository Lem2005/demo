package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import com.example.demo.dto.Producto;

public interface ProductoServices {
    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(String id);
    Producto createProducto(Producto producto);
    Producto updateProducto(String id, Producto producto);
}
