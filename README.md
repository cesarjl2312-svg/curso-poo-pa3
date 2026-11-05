# PA3 - Gestión de Registros usando Colecciones (Java)

**Institución:** ISIL
**Curso:** Programación Orientada a Objetos (Código: 30626)
**Docente:** Wilder Julio Espinoza Bravo
**Fecha:** 2 de Noviembre de 2026

## Integrantes
- Angel Fernando Reyes Moreno
- César Augusto Maguiña Robles

## 📝 Descripción del Trabajo
Este proyecto consiste en una aplicación de consola desarrollada en Java que gestiona un conjunto de registros de **Productos** en memoria, tal como se solicita en el caso aplicado de la evaluación PA3.

Se utiliza el **Java Collections Framework (JCF)** para almacenar, manipular, buscar y ordenar los datos de manera dinámica, demostrando las ventajas de las colecciones frente a los arreglos estáticos vistos en las sesiones anteriores.

## 🛒 ¿Por qué elegimos gestionar Productos? (Actividad 1)
Elegimos el registro **Producto** (pensando en el inventario de una bodega o minimarket) porque:
- Es un caso cotidiano y fácil de explicar: todos entendemos qué es un producto, su presentación y su precio.
- La cantidad de productos cambia todo el tiempo (llegan nuevos, se dejan de vender, cambian de presentación), así que necesitamos una estructura que **crezca y se reduzca** sin un tamaño fijo.
- Permite aplicar de forma natural todas las operaciones del sílabo: agregar, recuperar, reemplazar, eliminar, buscar, ordenar por precio o por nombre y calcular descuentos.

Cada producto tiene tres atributos: `nombre`, `presentacion` y `precio`.

## 📂 Estructura del Proyecto
```
src/main/java/org/isil/
├── Producto.java          -> Clase del registro (atributos, constructor, getters, métodos y equals)
└── GestionProductos.java  -> Clase principal: crea la colección y ejecuta las operaciones
```

## ⚙️ Lógica de Almacenamiento y Operaciones
De acuerdo a los temas evaluados (sesiones 8 a 10), se implementó lo siguiente:

- **Creación de la colección (Actividad 2):** se declara `List<Producto> listaProductos = new ArrayList<>();`. Se usa la interfaz `List` en la declaración y la clase `ArrayList` en la creación, de modo que el código depende de la interfaz del JCF y no de una implementación concreta. Luego se cargan 5 productos con `add` y se muestran con un recorrido indicando la posición de cada uno.
- **Métodos de ArrayList (Actividad 3):**
  - `add(objeto)` y `add(indice, objeto)`: agregar al final o en una posición específica.
  - `get(indice)`: recuperar un producto.
  - `set(indice, objeto)`: reemplazar un producto.
  - `remove(indice)`: eliminar un producto (devuelve el eliminado).
  - `indexOf(objeto)` y `contains(objeto)`: búsqueda simple.
  - `size()`: total de registros.
- **Métodos de la clase Collections (Actividad 4):**
  - `Collections.sort(lista, comparador)`: ordena los productos por precio de menor a mayor.
  - `Collections.sort(lista)`: ordena los nombres alfabéticamente.
  - `Collections.reverse`, `Collections.max`, `Collections.min`, `Collections.shuffle` y `Collections.frequency` (esta última para detectar un producto registrado dos veces).
- **Cálculos (POO):** el método no void `calcularPrecioConDescuento` de la clase `Producto` calcula el precio con 10% de descuento.

### Decisión técnica: `equals()` en la clase Producto
Al probar el programa notamos que `indexOf` devolvía `-1` aunque el "Aceite de oliva" sí estaba en la lista. La causa es que, por defecto, Java compara objetos por su **referencia en memoria**, y el producto que buscábamos era un objeto nuevo. Por eso sobrescribimos `equals()` (y `hashCode()`) para que dos productos se consideren iguales cuando tienen el **mismo nombre y presentación**. Con ese cambio, `indexOf` y `contains` funcionan correctamente.

## ✅ ¿Por qué el uso de colecciones mejora la solución? (Actividad 5)
| Con arreglos (`Producto[]`) | Con colecciones (`ArrayList`) |
|---|---|
| Hay que definir el tamaño desde el inicio. | Crece y se reduce sola al agregar o eliminar. |
| Eliminar un elemento obliga a mover los demás a mano. | `remove` reorganiza la lista automáticamente. |
| Buscar u ordenar requiere programar los algoritmos. | `indexOf`, `contains` y `Collections.sort` ya están implementados y probados. |
| Más código y más riesgo de errores de índice. | Código más corto, legible y fácil de mantener. |

En resumen, las colecciones nos permiten concentrarnos en la lógica del negocio (gestionar productos) en lugar de reescribir operaciones básicas de almacenamiento.

## 🧪 Pruebas realizadas (salida esperada)
Al ejecutar `main` se comprobó que:
- La lista inicial muestra 5 productos (posiciones 0 a 4).
- `remove(1)` elimina el "Arroz integral" y `contains` confirma luego que ya no está (`false`).
- `indexOf` encuentra el "Aceite de oliva" en la posición 1.
- `Collections.sort` deja los productos ordenados por precio: Leche evaporada (S/ 4.50), Avena integral (S/ 12.50), Café molido (S/ 18.90), Hamburguesa de res (S/ 24.00) y Aceite de oliva (S/ 35.00).
- `frequency` detecta que "Leche evaporada" aparece 2 veces.
- Los precios con descuento se muestran con 2 decimales.

Nota: el resultado de `shuffle` cambia en cada ejecución porque mezcla los elementos al azar.

## 👥 Distribución del Trabajo
| Integrante | Responsabilidades |
|---|---|
| César Augusto Maguiña Robles | Creación del proyecto Maven, clase `Producto`, carga de datos y primera versión de las operaciones con ArrayList y Collections. |
| Angel Fernando Reyes Moreno | Pruebas del programa, corrección de la búsqueda con `indexOf` (método `equals`), operaciones adicionales (`contains`, `size`, `add` por posición, ordenamiento por precio, `max` y `min`), formato de salida y documentación del README. |

Ambos integrantes revisamos la solución final y participamos en el video de exposición.

## 🚀 Instrucciones de Ejecución
1. Clonar este repositorio: `git clone https://github.com/cesarjl2312-svg/curso-poo-pa3.git`
2. Abrir el proyecto en un IDE (IntelliJ IDEA, Apache NetBeans o Eclipse) como un proyecto Maven.
3. Asegurarse de tener configurado el JDK (Java 21 o superior).
4. Buscar la clase principal `GestionProductos.java` (ubicada en `src/main/java/org/isil/`).
5. Ejecutar el método `main`. Los resultados de las operaciones con las colecciones se mostrarán en la consola del IDE.

## 🎥 Video de Exposición
Enlace al video de sustentación en YouTube:
*[Haz clic aquí para ver el video de sustentación](https://drive.google.com/file/d/1so9QB0i3OMca6WBGXGKuZASO-ewncE_5/view?usp=sharing)*

