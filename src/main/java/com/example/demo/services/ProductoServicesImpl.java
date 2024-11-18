package com.example.demo.services;

import java.util.Random;
import com.example.demo.dao.ProductoRepository;
import com.example.demo.dto.Producto;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicesImpl implements ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductoServicesImpl.class);

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(String id) {
        Optional<Producto> searchProducto = productoRepository.findById(id);
        if (searchProducto.isPresent()) {
            return searchProducto;
        } else {
            logger.error("No se encontró el producto con id " + id);
            throw new NoSuchElementException("No se encontró el producto con id " + id);
        }
    }

    @Override
    public Producto createProducto(Producto producto) {
        Producto newProducto = new Producto();
        newProducto.setId(IdPersonalizada()); 
        newProducto.setNombre(producto.getNombre());
        newProducto.setPrecio(producto.getPrecio());
        newProducto.setExistencia(producto.getExistencia());
        newProducto.setDescripcion(producto.getDescripcion());
        newProducto.setNombreprov(producto.getNombreprov());
        productoRepository.save(newProducto);
        logger.info("Producto agregado con éxito");
        return newProducto;
    }

    private String IdPersonalizada() {
        int length = 10;
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            id.append(character.charAt(random.nextInt(character.length())));
        }
        
        return id.toString();
    }

    @Override
    public Producto updateProducto(String id, Producto producto) {
        Optional<Producto> optProducto = productoRepository.findById(id);
        if (optProducto.isPresent()) {
            Producto updateProducto = optProducto.get();
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setPrecio(producto.getPrecio());
            updateProducto.setExistencia(producto.getExistencia());
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setNombreprov(producto.getNombreprov());
            productoRepository.save(updateProducto);
            logger.info("Producto con id " + id + " actualizado correctamente");
            return updateProducto;
        } else {
            logger.error("No se encontró un producto para actualizar con id " + id);
            throw new NoSuchElementException("No se encontró un producto para actualizar con id " + id);
        }
    }
}
