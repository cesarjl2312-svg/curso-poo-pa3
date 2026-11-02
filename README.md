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

## ⚙️ Lógica de Almacenamiento y Operaciones
De acuerdo a los temas evaluados (sesiones 8 a 10), se implementó lo siguiente:
- **Creación de la Colección:** Se utilizó la interfaz `List` y la clase concreta `ArrayList` para almacenar objetos de la clase `Producto`.
- **Métodos de ArrayList:** Se aplicaron métodos para agregar (`add`), eliminar (`remove`), recuperar (`get`), modificar (`set`) y buscar la posición de un elemento (`indexOf`).
- **Métodos de la clase Collections:** Se aplicaron operaciones utilitarias como ordenar alfabéticamente (`sort`), mezclar aleatoriamente (`shuffle`), invertir el orden (`reverse`) y contar la frecuencia de un elemento (`frequency`).
- **Cálculos (POO):** Se utilizó un método no void de la clase `Producto` para calcular el precio con descuento.

## 🚀 Instrucciones de Ejecución
1. Clonar este repositorio en tu máquina local.
2. Abrir el proyecto en un IDE (IntelliJ IDEA, Apache NetBeans o Eclipse) como un proyecto Maven.
3. Asegurarse de tener configurado el JDK (Java 21 o superior).
4. Buscar la clase principal `GestionProductos.java` (ubicada en `src/main/java/org/isil/`).
5. Ejecutar el método `main`. Los resultados de las operaciones con las colecciones se mostrarán en la consola del IDE.

## 🎥 Video de Exposición
A continuación, el enlace al video de sustentación en YouTube (con cámaras encendidas y explicación de las decisiones técnicas):
*[PEGAR AQUÍ EL ENLACE DE YOUTUBE]*