package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento{

//ATRIBUTOS
    private String bandaPrincipal;
    private double costeMontaje;
    private final double COSTESFIJOS = 5000;
    private String listaCanciones;

//METODO CONSTRUCTOR PADRE
    public Concierto(String nuevoNombre, LocalDate nuevaFecha, Recinto nuevoRecinto, double nuevoPrecio, String nuevoId, String nuevoBandaPrincipal, double costeMontaje, TipoEvento nuevoTipo) {
        super(nuevoNombre, nuevaFecha, nuevoRecinto, nuevoPrecio, nuevoId, nuevoTipo);
    bandaPrincipal = nuevoBandaPrincipal;
    this.costeMontaje=costeMontaje;
    listaCanciones = null;
    }

//METODOS PROPIOS
    public String consultarBandaPrincipal(){
        return bandaPrincipal;
    }
    @Override
    public void mostrarInformacion(){
    super.mostrarInformacion();
        System.out.printf("%nBanda Principal: %s%n ", bandaPrincipal);
    }

    @Override
    public double calcularCosteOperativo() {
        return costeMontaje+COSTESFIJOS;
    }

    public double getCosteMontaje() {
        return costeMontaje;
    }

    public void setCosteMontaje(double costeMontaje) {
        this.costeMontaje = costeMontaje;
    }

    public String getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(String listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    @Override
    public String aCSV() {
        return "concierto" + super.aCSV() + ";" + bandaPrincipal + ";" + listaCanciones;
    }

    @Override
    public String aXML() {
        return "<concierto>\n" +
                "\t" + super.aXML() +
                "\t<bandaPrincipal>" + bandaPrincipal + "</bandaPrincipal>\n" +
                "\t<listaCanciones" + listaCanciones+ "</listaCanciones>\n" +
                "</concierto>\n";
    }
}
