package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
@Table(name = "product") 
public class Producto {

    @Id
    @Column(name= "id", length= 10, nullable= false)
    private String id;

    @Column(name= "nombre", length= 100)
    private String nombre;

    @Column(name= "precio", precision= 30, scale= 2)
    private BigDecimal precio;

    @Column(name= "existencia")
    private Integer existencia;

    @Column(name= "descripcion", length= 128)
    private String descripcion;

    @Column(name= "nombreprov", length= 100)
    private String nombreprov;

    public Producto() {
    }

    public Producto(String id, String nombre, BigDecimal precio, Integer existencia, String descripcion, String nombreprov) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.descripcion = descripcion;
        this.nombreprov = nombreprov;
    }
        public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Integer getExistencia() {
        return existencia;
    }
    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombreprov() {
        return nombreprov;
    }
    public void setNombreprov(String nombreprov) {
        this.nombreprov = nombreprov;
    }
    @Override
    public String toString(){
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencia=" + existencia + ", descripcion=" + descripcion + ", nombreprov=" + nombreprov + "]";
    }

}