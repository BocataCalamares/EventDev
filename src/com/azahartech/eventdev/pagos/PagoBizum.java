package com.azahartech.eventdev.pagos;

import com.azahartech.eventdev.util.UtilidadValidacion;

public class PagoBizum implements ProcesadorPago{

    //ATRIBUTO
    private String telefono;
    private int pin;

    //METODOS
    //CONSTRUCTOR


    public PagoBizum(String telefono, int pin) {
        this.telefono = telefono;
        this.pin = pin;
    }

    @Override
    public boolean procesarPago(double cantidad) {
        if(UtilidadValidacion.telefonoNueve(telefono)){
            return true;
        }else {
            return false;
        }
    }
}
