package org.isil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionProductos {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   SISTEMA DE GESTIÓN DE PRODUCTOS (PA3) ");
        System.out.println("=========================================\n");

        // 1. CREACIÓN DE LA COLECCIÓN
        List<Producto> listaProductos = new ArrayList<>();

        // 2. CARGA DE DATOS
        listaProductos.add(new Producto("Leche deslactosada", "Paquete x 6 bolsas", 20.00));
        listaProductos.add(new Producto("Arroz integral", "Bolsa 5 kg", 15.50));
        listaProductos.add(new Producto("Aceite de oliva", "Botella 1L", 35.00));
        listaProductos.add(new Producto("Avena integral", "Paquete 500g", 12.50));
        listaProductos.add(new Producto("Hamburguesa de res", "Paquete x 6 unidades", 24.00));

        // 3. LISTADO INICIAL
        System.out.println("--- LISTA ORIGINAL DE PRODUCTOS ---");
        for (int i = 0; i < listaProductos.size(); i++) {
            listaProductos.get(i).mostrarProducto();
        }

        // 4. APLICANDO MÉTODOS DE ArrayList
        System.out.println("\n--- OPERACIONES CON ArrayList ---");

        listaProductos.remove(1);
        System.out.println("Se eliminó el producto en el índice 1 (Arroz integral).");

        listaProductos.set(0, new Producto("Leche evaporada", "Tarrito 400g", 4.50));
        System.out.println("Se modificó el producto en el índice 0 (Leche evaporada).");

        Producto buscar = new Producto("Aceite de oliva", "Botella 1L", 35.00);
        int posicion = listaProductos.indexOf(buscar);
        if (posicion != -1) {
            System.out.println("El 'Aceite de oliva' se encuentra en la posición: " + posicion);
        }

        // 5. APLICANDO LA CLASE Collections
        System.out.println("\n--- OPERACIONES CON LA CLASE Collections ---");

        List<String> nombresProductos = new ArrayList<>();
        for (Producto p : listaProductos) {
            nombresProductos.add(p.getNombre());
        }

        Collections.sort(nombresProductos);
        System.out.println("Nombres ordenados alfabéticamente: " + nombresProductos);

        Collections.shuffle(nombresProductos);
        System.out.println("Nombres mezclados aleatoriamente: " + nombresProductos);

        Collections.reverse(nombresProductos);
        System.out.println("Nombres en orden inverso: " + nombresProductos);

        nombresProductos.add("Leche evaporada");
        int veces = Collections.frequency(nombresProductos, "Leche evaporada");
        System.out.println("El producto 'Leche evaporada' aparece " + veces + " veces.");
        // 6. CÁLCULO FINAL
        System.out.println("\n--- CÁLCULOS DE PRECIOS CON DESCUENTO ---");
        for (Producto p : listaProductos) {
            double precioFinal = p.calcularPrecioConDescuento(10);
            System.out.println(p.getNombre() + " -> Precio Original: S/ " + p.getPrecio() + " | Con 10% dcto: S/ " + precioFinal);
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}