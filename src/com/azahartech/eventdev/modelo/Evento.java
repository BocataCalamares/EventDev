package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Evento implements Exportable {

    //ATRIBUTOS
    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precio;
    private boolean esBenefico = false;
    private String id;
    private EstadoEvento estado;
    private TipoEvento tipo;

    //METODOS
    //CONSTRUCTOR
    public Evento(String nuevoNombre, LocalDate nuevaFecha, Recinto nuevoRecinto, double nuevoPrecio, String nuevoId, TipoEvento nuevoTipo){
        nombre=nuevoNombre;
        fecha=nuevaFecha;
        recinto=nuevoRecinto;
        precio=nuevoPrecio;
        this.tipo=nuevoTipo;
        this.estado = EstadoEvento.PLANIFICADO;
        if (precio<=10){
            esBenefico=true;
        }
        id = nuevoId;
    }
    //CONSULTAS
    public String getNombre(){
        return nombre;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public double getPrecio(){return precio;}
    public Recinto getRecinto(){
        return recinto;
    }
    public void mostrarInformacion(){
        System.out.printf("---EVENTO---%nEl evento %s se realizará el dia %s en %s el evento será: %s%n---%n ", nombre, fecha, recinto.consultarNombreRecinto(), tipo.getDescripcion());
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public boolean registrarVenta(int cantidad) {
        if (estado == EstadoEvento.ACTIVO) {
            System.out.printf("Venta registrada%n");
            return true;
        } else {
            System.out.println("El evento está: " + estado);
            return false;
        }
    }
    @Override
    public String toString() {
        return nombre;
    }

    public boolean isEsBenefico() {
        return esBenefico;
    }

    public void setEsBenefico(boolean esBenefico) {
        this.esBenefico = esBenefico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public final String obtenerCodigoReferencia(){
        return "REF-" + getId() + "-NOM" + getNombre();
    }
    public abstract double calcularCosteOperativo();

    public final double calcularPrecioVentaRecomendado(){
     return (calcularCosteOperativo()/ getRecinto().consultarAforoMaximo())*(1 + 0.20);
    }

    @Override
    public String aCSV() {
        return  nombre + ";" + getRecinto().consultarAforoMaximo() + ";" + fecha;
    }

    @Override
    public String aXML() {
        return "\t<nombreEvento>" + this.nombre + "</nombreEvento>\n" +
                "\t" + recinto.aXML() +
                "\t<fecha>" + fecha + "</fecha>\n" +
                "\t<precio>" + precio + "</precio>\n" +
                "\t<benefico>" + esBenefico + "</benefico>";
    }
    //METODOS
    public void activarVenta(){
        estado=EstadoEvento.ACTIVO;
    }
    public void cancelarEvento(){
        estado=EstadoEvento.CANCELADO;
    }
    public void finalizarEvento(){
        estado=EstadoEvento.FINALIZADO;
    }

    /*@Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id);
    } */

    @Override
    public boolean equals(Object eventoPrueba) {
        boolean banderita;
        if (eventoPrueba == null || getClass() != eventoPrueba.getClass()){
            return banderita = false;
        }else{
            Evento evento = (Evento) eventoPrueba;
            return banderita = Objects.equals(id, evento.id);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
