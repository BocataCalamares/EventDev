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
}

