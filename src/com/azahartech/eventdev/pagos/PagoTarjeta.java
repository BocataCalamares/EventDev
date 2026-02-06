package com.azahartech.eventdev.pagos;

import com.azahartech.eventdev.util.UtilidadValidacion;

import java.util.Random;

public class PagoTarjeta implements ProcesadorPago{

    //ATRIBUTOS
    String numeroTarjeta;
    String fechaCaducidad;
    Random random = new Random();
    
    
    public PagoTarjeta(String numeroTarjeta, String fechaCaducidad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
            
        }
    @Override
    public boolean procesarPago(double cantidad) {
        int probability;
        probability = random.nextInt(1, 11);
        System.out.println("Procesando pago de " + cantidad + " con Tarjeta " + numeroTarjeta + "...");
        if (UtilidadValidacion.esNumeroTarjetaValido(numeroTarjeta)&& probability>1){
            System.out.println("Pago realizado correctamente");
            return true;
        }else {
            System.out.println("Error al realizar el pago");
            return false;
        }

    }
        
}

    

