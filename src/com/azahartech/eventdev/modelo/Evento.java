package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import java.time.LocalDate;

public abstract class Evento implements Exportable {

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
    public String getNombre(){
        return nombre;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public double getPrecio(){return precio;}
    public Recinto getRecinto(){
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
    public final String obtenerCodigoReferencia(){
        return "REF-" + getId() + "-NOM" + getNombre();
    }
    public abstract double calcularCosteOperativo();

    public final double calcularPrecioVentaRecomendado(){
     return (calcularCosteOperativo()/ getRecinto().consultarAforoMaximo())*(1 + 0.20);
    }

    @Override
    public String aCSV() {
        return  nombre + ";" + getRecinto().consultarAforoMaximo() + ";" + fecha;
    }

    @Override
    public String aXML() {
        return "\t<nombreEvento>" + this.nombre + "</nombreEvento>\n" +
                "\t" + recinto.aXML() +
                "\t<fecha>" + fecha + "</fecha>\n" +
                "\t<precio>" + precio + "</precio>\n" +
                "\t<benefico>" + esBenefico + "</benefico>";
    }
}
