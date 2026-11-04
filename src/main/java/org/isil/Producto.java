package org.isil;

import java.util.Objects;

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
        System.out.printf("Producto: %-20s | Presentación: %-22s | Precio: S/ %.2f%n",
                nombre, presentacion, precio);
    }

    // Método no void
    public double calcularPrecioConDescuento(double porcentajeDescuento) {
        return this.precio - (this.precio * (porcentajeDescuento / 100));
    }

    // Dos productos son iguales si tienen el mismo nombre y presentación.
    // Sin este método, indexOf, contains y remove(Object) del ArrayList
    // comparan referencias de memoria y nunca encuentran un objeto "nuevo"
    // con los mismos datos.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto)) return false;
        Producto otro = (Producto) obj;
        return nombre.equalsIgnoreCase(otro.nombre)
                && presentacion.equalsIgnoreCase(otro.presentacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), presentacion.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre + " (" + presentacion + ")";
    }
}
