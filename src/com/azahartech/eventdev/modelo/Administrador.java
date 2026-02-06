package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Notificable;

public class Administrador implements Notificable {




    //METODOS
    @Override
    public void enviarNotificaciones(String mensaje) {
        System.out.println("Administrador: " + mensaje);

    }
}
