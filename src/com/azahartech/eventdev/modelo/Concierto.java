package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento{

//ATRIBUTOS
    private String bandaPrincipal;
    private double costeMontaje;
    private final double COSTESFIJOS = 5000;

//METODO CONSTRUCTOR PADRE
    public Concierto(String nuevoNombre, LocalDate nuevaFecha, Recinto nuevoRecinto, double nuevoPrecio, String nuevoId, String nuevoBandaPrincipal, double costeMontaje) {
        super(nuevoNombre, nuevaFecha, nuevoRecinto, nuevoPrecio, nuevoId);
    bandaPrincipal = nuevoBandaPrincipal;
    this.costeMontaje=costeMontaje;
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

    @Override
    public String aCSV() {
        return "concierto" + super.aCSV() + ";" + bandaPrincipal;
    }

    @Override
    public String aXML() {
        return "<concierto>\n" +
                "\t" + super.aXML() +
                "\t<bandaPrincipal>" + bandaPrincipal + "</bandaPrincipal>\n" +
                "</concierto>\n";
    }
}
