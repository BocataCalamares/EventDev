package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.pagos.ProcesadorPago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
    //private Evento[] carteleraDestacados;
    //private ArrayList<Evento> listaEventos;
    private RepositorioGenerico<Evento> repositorio = new RepositorioGenerico<>();
    private HashMap<String, Evento> mapaEventos = new HashMap<>();
    private ProcesadorPago pasarela;

    public ServicioEvento() {
        //this.listaEventos = new ArrayList<>();
        //carteleraDestacados = new Evento[5];
        Recinto Cdf = new Recinto("Casal de Festes", "Calle Colón nº5", 550);
        //eventoDePrueba = new Evento("Feria de Mayo", LocalDate.of(2025, 12, 27), Cdf, 20, "VAMS");
        DetallePago factura = new DetallePago("Mastercard", "7512348951");
        usuarioDePrueba = new Usuario("Pedro", "Pedro@mail.com", true);
        usuarioDePrueba.añadirDetallePago(factura);


    }

    public Ticket realizarCompra(int cantidad, Usuario usuario, Evento evento, ProcesadorPago pasarela) {
       // usuarioDePrueba.consultarDetallePago().realizarPago(eventoDePrueba.getPrecio() * cantidad);
       boolean pagoExitoso = pasarela.procesarPago(eventoDePrueba.getPrecio() * cantidad);
        if (pagoExitoso){
            eventoDePrueba.registrarVenta(cantidad);
            return new Ticket(eventoDePrueba, usuarioDePrueba);
        } else {
            System.err.println("El pago ha sido rechazado");
            return null;
        }

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
            if(eventoActual.getFecha().isBefore(LocalDate.now())){
                it.remove();
                System.out.println("Eliminado evento caducado " + eventoActual.getNombre());
            }
        }
    } */
    public void eliminarEvento(Evento evento){
        repositorio.eliminar(evento);
    }

    public Evento buscarEvento(String nombreEvento){
        Evento eventoBuscado;
        eventoBuscado = repositorio.listar().stream().filter(e->e.getNombre().toLowerCase().equals(nombreEvento)).findFirst().orElse(null);
        return eventoBuscado;

    }

    public ArrayList<Evento>obtenerEventosConAforoMayor(int capacidad){
        ArrayList<Evento> eventosAforoMax;
        eventosAforoMax = repositorio.listar().stream().filter(e -> e.getRecinto().consultarAforoMaximo()>capacidad).collect(Collectors.toCollection(ArrayList::new));
        return eventosAforoMax;
    }
    public long contarEventosPorAforo(int aforoMinimo){

        return mapaEventos.values().stream().filter(evento-> evento.getRecinto().consultarAforoMaximo()>aforoMinimo).count();

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
                if (carteleraDestacados[i].getPrecio() > precio) {
                    eventoMasCaro = carteleraDestacados[i];
                    precio = carteleraDestacados[i].getPrecio();

                }

            }
        }
        return eventoMasCaro;

    } */
    public void generarInformeFinanciero(){
        for(Evento evento : mapaEventos.values()){
            System.out.println("Evento: " + evento.getNombre());
            System.out.println("Coste opetativo: " + evento.calcularCosteOperativo());
            System.out.println("Precio Sugerido: " + evento.calcularPrecioVentaRecomendado());
        }
    }

    public void procesarCierreEventos(){
        Scanner teclado = new Scanner(System.in);
        for(Evento evento : mapaEventos.values()){
            if (evento.getEstado()==EstadoEvento.ACTIVO){
               if(evento instanceof Partido){
                   System.out.println("Cerrando partido " + evento.getNombre());
                   Partido partido = (Partido) evento;
                   String resultado;
                   System.out.println("Resultado del partido");
                   resultado = teclado.nextLine();
                   partido.setResultadoMarcador(resultado);
               } else if(evento instanceof Concierto){
                    System.out.println("Cerrando concierto " + evento.getNombre());
                     Concierto concierto = (Concierto) evento;
                     String cancion;
                   System.out.println("Nombre de la canción");
                   cancion = teclado.nextLine();
                   concierto.setListaCanciones(cancion);
                }else {
                   System.out.println("Cerrando evento genérico");
                }
                evento.finalizarEvento();
            }
        }

        mapaEventos.values().stream()
                .filter(evento -> evento.getEstado()==EstadoEvento.FINALIZADO)
                .forEach(evento -> System.out.println(evento.aCSV()));
    }
}




