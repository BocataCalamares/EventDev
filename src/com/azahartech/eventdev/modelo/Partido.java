package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento {

    //ATRIBUTOS
    private String equipoLocal;
    private String equipoVisitante;
    private double costeSeguridad;
    private double costeArbitraje;
    private final double COSTESFIJOS = 2000;
    private String resultadoMarcador;


    //METODO CONSTRUCTOR PADRE
    public Partido(String nuevoNombre, LocalDate nuevaFecha, Recinto nuevoRecinto, double nuevoPrecio, String nuevoId, String nuevoEquipoLocal, String nuevoEquipoVisitante, double costeArbitraje, double costeSeguridad, TipoEvento nuevoTipo) {
        super(nuevoNombre, nuevaFecha, nuevoRecinto, nuevoPrecio, nuevoId, nuevoTipo);
        equipoLocal=nuevoEquipoLocal;
        equipoVisitante=nuevoEquipoVisitante;
        this.costeSeguridad = costeSeguridad;
        this.costeArbitraje = costeArbitraje;
        resultadoMarcador = null;
    }
    //METODOS PROPIOS
    public String consultarEquipoLocal(){
        return equipoLocal;
    }
    public String consultarEquipoVisitante(){
        return equipoVisitante;
    }
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.printf("---PARTIDO----%n%s vs %s%n----%n", equipoLocal, equipoVisitante);
    }

    public double getCosteSeguridad() {
        return costeSeguridad;
    }

    public void setCosteSeguridad(double costeSeguridad) {
        this.costeSeguridad = costeSeguridad;
    }

    public double getCosteArbitraje() {
        return costeArbitraje;
    }

    public void setCosteArbitraje(double costeArbitraje) {
        this.costeArbitraje = costeArbitraje;
    }

    public void setResultadoMarcador(String resultadoMarcador) {
        this.resultadoMarcador = resultadoMarcador;
    }

    public String getResultadoMarcador() {
        return resultadoMarcador;
    }

    @Override
    public double calcularCosteOperativo() {
        return costeArbitraje + costeSeguridad + COSTESFIJOS;
    }

    @Override
    public String aCSV() {
        return "Partido:" + super.aCSV() + ";" + equipoVisitante + ";" + equipoLocal + ";" + resultadoMarcador;
    }

    @Override
    public String aXML() {
        return "<partido>\n" + super.aXML() + "\n" +
                "\t<equipoVisitante>" + equipoVisitante + "</equipoVisitante>\n" +
                "\t<equipoLocal>" + equipoLocal + "</equipoLocal>\n" +
                "\t<resultado>" + resultadoMarcador + "</resultado>\n" +
                "</partido>";
    }
}
