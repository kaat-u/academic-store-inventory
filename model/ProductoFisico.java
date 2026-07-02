package com.lideratec.model;

import com.lideratec.interfaces.Descontable;

public class ProductoFisico extends Producto implements Descontable {

    private double pesoKg;

    public ProductoFisico(String codigo, String nombre, double precio, double pesoKg) {
        super(codigo, nombre, precio);
        this.pesoKg = pesoKg;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public void mostrarInfo() {
        System.out.printf("[Fisico]  Codigo: %-6s | Nombre: %-20s | Precio: S/ %8.2f | Peso: %.2f kg%n",
                getCodigo(), getNombre(), getPrecio(), pesoKg);
    }

    @Override
    public double aplicarDescuento(double porcentajeDescuento) {
        double nuevoPrecio = getPrecio() - (getPrecio() * porcentajeDescuento / 100.0);
        setPrecio(nuevoPrecio);
        return nuevoPrecio;
    }
}