package com.lideratec.service;

import com.lideratec.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inventario {

    private List<Producto> productos;
    private Set<String> codigosRegistrados;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.codigosRegistrados = new HashSet<>();
    }

    public boolean registrarProducto(Producto producto) {
        if (producto == null) {
            return false;
        }
        if (codigosRegistrados.contains(producto.getCodigo())) {
            return false;
        }
        productos.add(producto);
        codigosRegistrados.add(producto.getCodigo());
        return true;
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public void ordenarPorPrecio() {
        productos.sort(Comparator.comparingDouble(Producto::getPrecio));
    }

    public void ordenarPorNombre() {
        productos.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Producto> getProductos() {
        return productos;
    }
}