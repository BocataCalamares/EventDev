package com.azahartech.eventdev.modelo;

import java.time.LocalDate;
import java.util.UUID;

public class Evento {

    //ATRIBUTOS
    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precio;
    private boolean esBenefico = false;
    private String id;

    //METODOS
    //CONSTRUCTOR
    public Evento(String nuevoNombre, LocalDate nuevaFecha, Recinto nuevoRecinto, double nuevoPrecio, String nuevoId){
        nombre=nuevoNombre;
        fecha=nuevaFecha;
        recinto=nuevoRecinto;
        precio=nuevoPrecio;
        if (precio<=10){
            esBenefico=true;
        }
        id = nuevoId;
    }
    //CONSULTAS
    public String consultarNombre(){
        return nombre;
    }
    public LocalDate consultarFecha(){
        return fecha;
    }
    public double consultarPrecio(){return precio;}
    public Recinto consultarRecinto(){
        return recinto;
    }
    public void mostrarInformacion(){
        System.out.printf("---EVENTO---%nEl evento %s se realizará el dia %s en %s%n---%n", nombre, fecha, recinto.consultarNombreRecinto());
    }
    public void registrarVenta(int cantidad){
        System.out.printf("Venta registrada%n");
    }

    @Override
    public String toString() {
        return nombre;
    }

    public boolean isEsBenefico() {
        return esBenefico;
    }

    public void setEsBenefico(boolean esBenefico) {
        this.esBenefico = esBenefico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
