package com.azahartech.eventdev.util;

import java.time.LocalDate;

public class UtilidadValidacion {
    public static boolean esEmailValido(String email) {
        /*if (email.contains("@") && !email.startsWith("@")) {
            return true;
        } else {
            return false;
        }*/
        return email.matches("\\w+@\\w+\\.[a-z]{2,4}");

    }

    public static boolean esPuntuacionValida(int puntuacion) {
        if (puntuacion > 5 || puntuacion < 0) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean esFechaFutura(LocalDate fecha){
            if(fecha.isAfter(LocalDate.now())){
                return true;
            }else{
                return false;
            }

    }
    public static boolean esCodigoEventoValido(String codigo){
        return codigo.matches("EVT-\\d{4}-[A-Z]{3}");
    }
    public static boolean esTelefonoValido(String telefono){
        return telefono.matches("^[679]\\d{8}$");
    }
    public static boolean esNumeroTarjetaValido(String numeroTarjeta){
        return numeroTarjeta.matches("\\d{16}");
    }
    public static boolean telefonoNueve(String telefono){
        return telefono.matches("\\d{9}");
    }
    //public static boolean tarjetaCaducada(String fechaCaducidad){
    //    return fechaCaducidad
    //}
}

