package com.lideratec;

import com.lideratec.model.Producto;
import com.lideratec.model.ProductoDigital;
import com.lideratec.model.ProductoFisico;
import com.lideratec.service.Inventario;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Inventario inventario = new Inventario();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosDePrueba();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> inventario.listarProductos();
                case 3 -> buscarPorCodigo();
                case 4 -> buscarPorNombre();
                case 5 -> {
                    inventario.ordenarPorPrecio();
                    System.out.println("Productos ordenados por precio:");
                    inventario.listarProductos();
                }
                case 6 -> {
                    inventario.ordenarPorNombre();
                    System.out.println("Productos ordenados por nombre:");
                    inventario.listarProductos();
                }
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intenta de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== TIENDA ACADEMICA - MENU =====");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar por codigo");
        System.out.println("4. Buscar por nombre");
        System.out.println("5. Ordenar por precio");
        System.out.println("6. Ordenar por nombre");
        System.out.println("0. Salir");
    }

    private static void registrarProducto() {
        System.out.println("Tipo de producto: 1) Fisico  2) Digital");
        int tipo = leerEntero("Opción: ");

        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        double precio = leerDouble("Precio: ");

        Producto producto;
        if (tipo == 1) {
            double peso = leerDouble("Peso (kg): ");
            producto = new ProductoFisico(codigo, nombre, precio, peso);
        } else {
            double tamano = leerDouble("Tamaño (MB): ");
            producto = new ProductoDigital(codigo, nombre, precio, tamano);
        }

        boolean registrado = inventario.registrarProducto(producto);
        if (registrado) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("Error: ya existe un producto con ese código.");
        }
    }

    private static void buscarPorCodigo() {
        System.out.print("Código a buscar: ");
        String codigo = sc.nextLine();
        Producto encontrado = inventario.buscarPorCodigo(codigo);
        if (encontrado != null) {
            encontrado.mostrarInfo();
        } else {
            System.out.println("No se encontró ningún producto con ese código.");
        }
    }

    private static void buscarPorNombre() {
        System.out.print("Nombre (o parte del nombre) a buscar: ");
        String nombre = sc.nextLine();
        List<Producto> resultados = inventario.buscarPorNombre(nombre);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron productos con ese nombre.");
        } else {
            resultados.forEach(Producto::mostrarInfo);
        }
    }

    private static void cargarDatosDePrueba() {
        inventario.registrarProducto(new ProductoFisico("F001", "Cuaderno Universitario", 12.50, 0.30));
        inventario.registrarProducto(new ProductoFisico("F002", "Calculadora Cientifica", 85.00, 0.25));
        inventario.registrarProducto(new ProductoDigital("D001", "Curso de Java Basico", 49.90, 350));
        inventario.registrarProducto(new ProductoDigital("D002", "E-book Estructuras de Datos", 25.00, 15));
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }
}