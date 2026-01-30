package com.azahartech.eventdev.pagos;

import com.azahartech.eventdev.util.UtilidadValidacion;

public class PagoTarjeta implements ProcesadorPago{

    //ATRIBUTOS
    String numeroTarjeta;
    String fechaCaducidad;

    
    
    public PagoTarjeta(String numeroTarjeta, String fechaCaducidad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
            
        }
    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Procesando pago de " + cantidad + " con Tarjeta " + numeroTarjeta + "...");
        if (UtilidadValidacion.esNumeroTarjetaValido(numeroTarjeta)){
            System.err.println("Pago realizado correctamente");
            return true;
        }else {
            System.err.println("Error al realizar el pago");
            return false;
        }

    }
        
}

    

