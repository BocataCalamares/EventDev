package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import java.time.LocalDate;
import java.util.UUID;

public class Ticket implements Exportable {
    //ATRIBUTOS
    private String id;
    private Evento evento;
    private Usuario comprador;
    private LocalDate fechaCompra;
    private static int contadorDeTickets = 0;

    //METODOS

    public Ticket(Evento nuevoEvento, Usuario nuevoComprador){
        id= UUID.randomUUID().toString();
        evento = nuevoEvento;
        comprador = nuevoComprador;
        fechaCompra = LocalDate.now();
        contadorDeTickets++;
    }

    public static int obtenerTotalTickets(){
        return contadorDeTickets;
    }
    public void mostrarInformacion(){
        System.out.printf("---TICKET----%n");
        comprador.mostrarInforamcion();
        evento.mostrarInformacion();
        System.out.printf("----%n");


    }


    @Override
    public String aCSV() {
        return "Ticket: " + id + ";" + evento.aCSV() + ";" + comprador.aCSV() + ";" + fechaCompra;
    }

    @Override
    public String aXML() {
        return "<ticket>\n" +
                "\t<id>" + id + "</id>\n" +
                "\t<evento>" + evento.aXML() + "</evento>\n" +
                "\t<comprador>" + comprador.aXML() + "</comprador>\n" +
                "\t<fechacompra>" + fechaCompra + "</fechacompra>\n" +
                "</ticket>\n";
    }
}
