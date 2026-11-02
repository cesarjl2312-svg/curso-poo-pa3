package org.isil;

public class Producto {
    // Atributos
    private String nombre;
    private String presentacion;
    private double precio;

    // Constructor
    public Producto(String nombre, String presentacion, double precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getPresentacion() { return presentacion; }
    public double getPrecio() { return precio; }

    // Método void
    public void mostrarProducto() {
        System.out.println("Producto: " + nombre + " | Presentación: " + presentacion + " | Precio: S/ " + precio);
    }

    // Método no void
    public double calcularPrecioConDescuento(double porcentajeDescuento) {
        return this.precio - (this.precio * (porcentajeDescuento / 100));
    }
}