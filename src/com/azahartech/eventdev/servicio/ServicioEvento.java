package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
    //private Evento[] carteleraDestacados;
    //private ArrayList<Evento> listaEventos;
    private RepositorioGenerico<Evento> repositorio = new RepositorioGenerico<>();
    private HashMap<String, Evento> mapaEventos = new HashMap<>();


    public ServicioEvento() {
        //this.listaEventos = new ArrayList<>();
        //carteleraDestacados = new Evento[5];
        Recinto Cdf = new Recinto("Casal de Festes", "Calle Colón nº5", 550);
        eventoDePrueba = new Evento("Feria de Mayo", LocalDate.of(2025, 12, 27), Cdf, 20);
        DetallePago factura = new DetallePago("Mastercard", "7512348951");
        usuarioDePrueba = new Usuario("Pedro", "Pedro@mail.com", true);
        usuarioDePrueba.añadirDetallePago(factura);


    }

    public Ticket realizarCompra(int cantidad) {
        usuarioDePrueba.consultarDetallePago().realizarPago(eventoDePrueba.consultarPrecio() * cantidad);
        eventoDePrueba.registrarVenta(cantidad);
        return new Ticket(eventoDePrueba, usuarioDePrueba);
    }

   /* public void añadirDestacado(Evento evento) {
       listaEventos.add(evento);
    } */

    public void mostrarTodosEventos() {
      /*for(Evento listaEvento : repositorio.listar()){
          listaEvento.mostrarInformacion();
      } */
        /*for (Evento listaEvento : listaEventos){

                listaEvento.mostrarInformacion();
            }*/
        for (Evento evento : mapaEventos.values()) {
            evento.mostrarInformacion();
            }
        }
    public void registrarEvento (Evento evento){

        //listaEventos.add(evento);
        //repositorio.guardar(evento);
        mapaEventos.put(evento.getId(), evento);
    }
    /*public void eliminarEventosPasados(){
        Iterator<Evento> it = this.listaEventos.iterator();
        while(it.hasNext()){
            Evento eventoActual = it.next();
            if(eventoActual.consultarFecha().isBefore(LocalDate.now())){
                it.remove();
                System.out.println("Eliminado evento caducado " + eventoActual.consultarNombre());
            }
        }
    } */
    public void eliminarEvento(Evento evento){
        repositorio.eliminar(evento);
    }

    public Evento buscarEvento(String nombreEvento){
        Evento eventoBuscado;
        eventoBuscado = repositorio.listar().stream().filter(e->e.consultarNombre().toLowerCase().equals(nombreEvento)).findFirst().orElse(null);
        return eventoBuscado;

    }

    public ArrayList<Evento>obtenerEventosConAforoMayor(int capacidad){
        ArrayList<Evento> eventosAforoMax;
        eventosAforoMax = repositorio.listar().stream().filter(e -> e.consultarRecinto().consultarAforoMaximo()>capacidad).collect(Collectors.toCollection(ArrayList::new));
        return eventosAforoMax;
    }
    public long contarEventosPorAforo(int aforoMinimo){

        return mapaEventos.values().stream().filter(evento-> evento.consultarRecinto().consultarAforoMaximo()>aforoMinimo).count();

    }

    public long contarEventosBeneficos(){
        long numeroEventos;
        numeroEventos = repositorio.listar().stream().filter(e->e.isEsBenefico()).count();
        return numeroEventos;
    }

    public Evento buscarEventoId(String id){
        return mapaEventos.get(id);
    }

    public void eliminarEvento(String id){
        mapaEventos.remove(id);
    }



    /* public Evento buscarDestacadoMasCaro() {
        Evento eventoMasCaro = null;
        double precio = 0;
        for (int i = 0; i < carteleraDestacados.length; i++) {
            if (carteleraDestacados[i] != null) {
                if (carteleraDestacados[i].consultarPrecio() > precio) {
                    eventoMasCaro = carteleraDestacados[i];
                    precio = carteleraDestacados[i].consultarPrecio();

                }

            }
        }
        return eventoMasCaro;

    } */




}
