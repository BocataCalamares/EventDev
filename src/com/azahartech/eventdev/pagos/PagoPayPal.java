package com.azahartech.eventdev.pagos;

public class PagoPayPal implements ProcesadorPago {

    //ATRIBUTOS
    private String email;

    //METODOS
    //CONSTRUCTOR
    public PagoPayPal(String email) {
        this.email = email;
    }

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Redirigiendo a PayPal para el usuario " + email + "...");
        System.out.println("Cobro de " + cantidad + " realizado con exito");
        return true;
    }
}
