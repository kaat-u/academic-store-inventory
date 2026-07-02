package com.lideratec.model;

import com.lideratec.interfaces.Descontable;

public class ProductoDigital extends Producto implements Descontable {

    private double tamanoMB;

    public ProductoDigital(String codigo, String nombre, double precio, double tamanoMB) {
        super(codigo, nombre, precio);
        this.tamanoMB = tamanoMB;
    }

    public double getTamanoMB() {
        return tamanoMB;
    }

    @Override
    public void mostrarInfo() {
        System.out.printf("[Digital] Codigo: %-6s | Nombre: %-20s | Precio: S/ %8.2f | Tamano: %.1f MB%n",
                getCodigo(), getNombre(), getPrecio(), tamanoMB);
    }

    @Override
    public double aplicarDescuento(double porcentajeDescuento) {
        double nuevoPrecio = getPrecio() - (getPrecio() * porcentajeDescuento / 100.0);
        setPrecio(nuevoPrecio);
        return nuevoPrecio;
    }
}