package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

public class DetallePago implements Exportable {

    //ATRIBUTOS
    private String tipoTarjeta;
    private String numeroTarjeta;
    private double total;

    //METODOS
    public DetallePago(String nuevoTipoTarjeta, String nuevoNumeroTarjeta){
        tipoTarjeta=nuevoTipoTarjeta;
        numeroTarjeta=nuevoNumeroTarjeta;
    }
    //REALIZAR PAGO
    public void realizarPago(double costeTotal) {
        System.out.println(costeTotal);
    }
    public void realizarPago(double costeTotal, String tipoTarjeta){
        this.realizarPago(costeTotal);
    }

    public void cambiarTipoTarjeta(String nuevoTipoTarjeta){
        tipoTarjeta = nuevoTipoTarjeta;
    };
    public void cambiarNumeroTarjeta(String nuevoNumeroTarjeta){
        numeroTarjeta=nuevoNumeroTarjeta;
    };
    public String consultarTipoTarjeta(){
        return tipoTarjeta;
    };
    public String consultarNumeroTarjeta() {
        return numeroTarjeta;
    };
    public void mostrarInformacion(){
        System.out.printf("---TARJETA---%nTipo: %s%nNumero: %s%n----%n", tipoTarjeta, numeroTarjeta);

    };

    @Override
    public String aCSV() {
        return "Detalles de pago: " + tipoTarjeta + ";" + numeroTarjeta;
    }

    @Override
    public String aXML() {
        return "<detallesPago>" +
                "\t<tipoTarjerta>" + tipoTarjeta + "</tipoTarjeta>\n" +
                "\t<numeroTarjeta>" + numeroTarjeta+ "</numeroTarjeta>\n" +
                "</detallesPago>\n";
    }

}

