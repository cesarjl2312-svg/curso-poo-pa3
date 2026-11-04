package org.isil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionProductos {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   SISTEMA DE GESTIÓN DE PRODUCTOS (PA3) ");
        System.out.println("=========================================");

        // 1. CREACIÓN DE LA COLECCIÓN
        // Se declara con la interfaz List y se instancia con ArrayList:
        // crece sola, no requiere tamaño fijo como un arreglo.
        List<Producto> listaProductos = new ArrayList<>();

        // 2. CARGA DE DATOS (add)
        listaProductos.add(new Producto("Leche deslactosada", "Paquete x 6 bolsas", 20.00));
        listaProductos.add(new Producto("Arroz integral", "Bolsa 5 kg", 15.50));
        listaProductos.add(new Producto("Aceite de oliva", "Botella 1L", 35.00));
        listaProductos.add(new Producto("Avena integral", "Paquete 500g", 12.50));
        listaProductos.add(new Producto("Hamburguesa de res", "Paquete x 6 unidades", 24.00));

        // 3. LISTADO INICIAL
        listar("LISTA ORIGINAL DE PRODUCTOS", listaProductos);

        // 4. APLICANDO MÉTODOS DE ArrayList
        System.out.println("\n--- OPERACIONES CON ArrayList ---");

        // get: recuperar un elemento por su índice
        Producto primero = listaProductos.get(0);
        System.out.println("get(0) -> primer producto registrado: " + primero);

        // remove: eliminar por índice
        Producto eliminado = listaProductos.remove(1);
        System.out.println("remove(1) -> se eliminó: " + eliminado);

        // set: reemplazar el elemento de una posición
        listaProductos.set(0, new Producto("Leche evaporada", "Tarrito 400g", 4.50));
        System.out.println("set(0) -> se reemplazó la posición 0 por: " + listaProductos.get(0));

        // add en una posición específica
        listaProductos.add(2, new Producto("Café molido", "Bolsa 250g", 18.90));
        System.out.println("add(2, ...) -> se insertó Café molido en la posición 2");

        // indexOf y contains: búsqueda simple (funcionan gracias a equals() en Producto)
        Producto buscar = new Producto("Aceite de oliva", "Botella 1L", 35.00);
        int posicion = listaProductos.indexOf(buscar);
        if (posicion != -1) {
            System.out.println("indexOf -> 'Aceite de oliva' está en la posición: " + posicion);
        } else {
            System.out.println("indexOf -> 'Aceite de oliva' no se encuentra en la lista.");
        }

        Producto arroz = new Producto("Arroz integral", "Bolsa 5 kg", 15.50);
        System.out.println("contains -> ¿sigue el 'Arroz integral'? " + listaProductos.contains(arroz));

        // size: cantidad de registros
        System.out.println("size -> total de productos: " + listaProductos.size());

        listar("LISTA DESPUÉS DE LAS OPERACIONES", listaProductos);

        // 5. APLICANDO LA CLASE Collections
        System.out.println("\n--- OPERACIONES CON LA CLASE Collections ---");

        // Ordenar los productos por precio (de menor a mayor)
        Collections.sort(listaProductos, (a, b) -> Double.compare(a.getPrecio(), b.getPrecio()));
        listar("PRODUCTOS ORDENADOS POR PRECIO (Collections.sort)", listaProductos);

        // Lista auxiliar con los nombres para las demás operaciones
        List<String> nombresProductos = new ArrayList<>();
        for (Producto p : listaProductos) {
            nombresProductos.add(p.getNombre());
        }

        Collections.sort(nombresProductos);
        System.out.println("\nsort -> nombres en orden alfabético: " + nombresProductos);

        Collections.reverse(nombresProductos);
        System.out.println("reverse -> nombres en orden inverso (Z-A): " + nombresProductos);

        System.out.println("max -> último nombre alfabético: " + Collections.max(nombresProductos));
        System.out.println("min -> primer nombre alfabético: " + Collections.min(nombresProductos));

        Collections.shuffle(nombresProductos);
        System.out.println("shuffle -> nombres mezclados aleatoriamente: " + nombresProductos);

        // frequency: se registra de nuevo un producto para detectar duplicados
        nombresProductos.add("Leche evaporada");
        int veces = Collections.frequency(nombresProductos, "Leche evaporada");
        System.out.println("frequency -> 'Leche evaporada' aparece " + veces + " veces (posible duplicado).");

        // 6. CÁLCULO FINAL
        System.out.println("\n--- CÁLCULOS DE PRECIOS CON DESCUENTO ---");
        for (Producto p : listaProductos) {
            double precioFinal = p.calcularPrecioConDescuento(10);
            System.out.printf("%-20s -> Precio original: S/ %6.2f | Con 10%% dcto: S/ %6.2f%n",
                    p.getNombre(), p.getPrecio(), precioFinal);
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }

    // Recorre la colección e imprime cada producto con su posición
    private static void listar(String titulo, List<Producto> lista) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print("[" + i + "] ");
            lista.get(i).mostrarProducto();
        }
    }
}
