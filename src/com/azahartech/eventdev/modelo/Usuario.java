package com.azahartech.eventdev.modelo;
import java.util.UUID;

public class Usuario {

    //ATRIBUTOS

    private final String id;
    private String nombreUsuario;
    private String email;
    private DetallePago detallePago;
    private boolean esVip;

    //METODOS
    //CREADOR ID(constructor)
    public Usuario(String nuevoNombreUsuario, String nuevoEmail, boolean nuevoEsVip){
        nombreUsuario = nuevoNombreUsuario;
        email = nuevoEmail;
        id = UUID.randomUUID().toString();
        esVip = nuevoEsVip;
    }
    //CONSULTAS
    public String consultarNombre(){
    return nombreUsuario;
    }
    public String consultarEmail(){
        return email;
    }
    public String consultarId(){
        return id;
    }
    public void mostrarInforamcion(){
        System.out.printf("---Usuario---%nNombre: %s%nEmail: %s%nID: %s%n---%n", nombreUsuario,email,id);
        if(!(detallePago==null)){
            detallePago.mostrarInformacion();
        }
    }
    public void cambiarEmail(String nuevoEmail){
        email=nuevoEmail;
    }

    public void añadirDetallePago(DetallePago nuevoDetallePago){

        detallePago=nuevoDetallePago;
    }

    public DetallePago consultarDetallePago() {
        return detallePago;
    }

    public boolean getEsVip() {
        return esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }
}
