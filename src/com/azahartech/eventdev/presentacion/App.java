package com.azahartech.eventdev.presentacion;
import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.pagos.PagoTarjeta;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.Exportable;
import com.azahartech.eventdev.util.UtilidadExportacion;
import com.azahartech.eventdev.util.UtilidadValidacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aplicación de gestión de eventos
 * @author Jonathan Rosa Aledón
 * @version 1.0
 */
public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Exportable> listaMezclada = new ArrayList<>();
        /* int opcion;
        String nombreEvento;
        int dia;
        int mes;
        int año;
        LocalDate fecha;
        String nombreRecinto;
        String direccionRecinto;
        int aforoMaximo;
        double precio;
        String bandaPrincipal;
        String equipoLocal;
        String equipoVisitante;

        do {
            System.out.printf("Bienvenido%n¿Que desea crear?%n1.Concierto%n2.Partido");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    teclado.nextLine();
                    System.out.println("Introduce el nombre del evento");
                    nombreEvento = teclado.nextLine();
                    System.out.println("Introduce el año del evento");
                    año = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Mes del evento");
                    mes = teclado.nextInt();
                    System.out.println("Dia del evento");
                    dia = teclado.nextInt();
                    fecha = LocalDate.of(año ,mes, dia);
                    System.out.println("Introduce el precio del evento");
                    precio = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Introduce el nombre del Recinto");
                    nombreRecinto = teclado.nextLine();
                    System.out.println("Introduce el direccion del Recinto");
                    direccionRecinto = teclado.nextLine();
                    System.out.println("Introduce el aforoMaximo del Recinto");
                    aforoMaximo = teclado.nextInt();
                    teclado.nextLine();
                    Recinto recinto1 = new Recinto(nombreRecinto, direccionRecinto, aforoMaximo);
                    Evento evento1 = new Evento(nombreEvento, fecha, recinto1, precio);
                    System.out.println("Datos Especificos del Concierto");
                    System.out.println("Banda Principal");
                    bandaPrincipal = teclado.nextLine();
                    Concierto concierto1 = new Concierto(nombreEvento, fecha, recinto1, precio, bandaPrincipal);
                    System.out.println(concierto1.consultarBandaPrincipal());
                    concierto1.mostrarInformacion();

                    break;
                case 2:
                    teclado.nextLine();
                    System.out.println("Introduce el nombre del evento");
                    nombreEvento = teclado.nextLine();
                    System.out.println("Introduce el año del evento");
                    año = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Mes del evento");
                    mes = teclado.nextInt();
                    System.out.println("Dia del evento");
                    dia = teclado.nextInt();
                    fecha = LocalDate.of(año ,mes, dia);
                    System.out.println("Introduce el precio del evento");
                    precio = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Introduce el nombre del Recinto");
                    nombreRecinto = teclado.nextLine();
                    System.out.println("Introduce el direccion del Recinto");
                    direccionRecinto = teclado.nextLine();
                    System.out.println("Introduce el aforoMaximo del Recinto");
                    aforoMaximo = teclado.nextInt();
                    teclado.nextLine();
                    Recinto recinto2 = new Recinto(nombreRecinto, direccionRecinto, aforoMaximo);
                    Evento evento2 = new Evento(nombreEvento, fecha, recinto2, precio);
                    System.out.println("Datos Especificos del Partido");
                    System.out.println("Equipo Local");
                    equipoLocal = teclado.nextLine();
                    System.out.println("Equipo Visitante");
                    equipoVisitante = teclado.nextLine();
                    Partido partido1 = new Partido(nombreEvento, fecha, recinto2, precio, equipoLocal, equipoVisitante);
                    System.out.println(partido1.consultarEquipoLocal());
                    System.out.println(partido1.consultarEquipoVisitante());
                    partido1.mostrarInformacion();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }while(opcion!= 1|| opcion!=2); **/


        /*USUARIO
    Usuario Pau = new Usuario("Pau", "paupasalo@gmail.com");
        */

        /*
        System.out.println(Pau.getNombre());
        System.out.println(Pau.consultarEmail());
        System.out.println(Pau.consultarId());
        Pau.mostrarInforamcion();
        Pau.cambiarEmail("papupasa@gmail.com");
        System.out.println(Pau.consultarEmail());

        Pau.mostrarInforamcion();

//RECINTO
    Recinto pdf = new Recinto("Palau de la Festa", "C/Fernando Cortes 13",
            570);
        System.out.println(pdf.consultarNombreRecinto());
        System.out.println(pdf.consultarDireccion());
        System.out.println(pdf.consultarNombreRecinto());
        pdf.mostrarInformacion();
*/
//EVENTO

/*
        System.out.println(fdl.getNombre());
        System.out.println(fdl.getFecha());
        System.out.println(fdl.getRecinto().consultarNombreRecinto());
        fdl.mostrarInformacion();
//PAGO

        System.out.println(pago.consultarTipoTarjeta());
        System.out.println(pago.consultarNumeroTarjeta());
        pago.mostrarInformacion();
        pago.cambiarTipoTarjeta("MasterCard");
        pago.cambiarNumeroTarjeta("1234568");
        System.out.println(pago.consultarTipoTarjeta());
        System.out.println(pago.consultarNumeroTarjeta());
        pago.mostrarInformacion();
//

       System.out.println(Ticket.obtenerTotalTickets());
       ticket.mostrarInformacion();
       ticket2.mostrarInformacion();
//COMENTARIO
        Comentario nota = new Comentario(fdl, Pau, 5, "Me ha gustado mucho");

        System.out.println(nota.consultarEvento());
        System.out.println(nota.consultarAutor());
        System.out.println(nota.consultarComentario());
        System.out.println(nota.consultarPuntuacion());
        nota.mostrarInformacion();
//SERVICIO EVENTO
         */
        ServicioEvento servicioEvento = new ServicioEvento();
        ServicioUsuario servicioUsuario = new ServicioUsuario();
       /* servicioEvento.realizarCompra(20); */

        //CONCIERTO
        Recinto recintoPrueba = new Recinto("recintoPrueba", "Calle Lavanda 5", 1000);
        Recinto recintoPrueba2 = new Recinto("recintoPrueba2", "C/Leopoldo III 25", 50);
        Recinto recintoPrueba3 = new Recinto("Bar Manolo", "C/Salvador Illa 16", 20);
        Recinto recintoPrueba4 = new Recinto("recintoPrueba4", "C/Tiramisú 5", 150);
       // Evento fdl = new Evento("Feria del Libro", LocalDate.of(2025,12,27), recintoPrueba2, 20, "ABCD");
        Evento fdl;
        Evento evento2;
        Evento evento3;
        Evento evento4;
        Evento evento5;
        //evento3 = new Evento("Feria Valencia", LocalDate.of(2026,10,25), recintoPrueba4, 70, "CABD");
        //evento4 = new Evento("Feria Vila-Real", LocalDate.of(2025, 12, 5), recintoPrueba3, 5, "BACD");
        //evento5 = new Evento("Feria Almassora", LocalDate.of(2026, 01, 3), recintoPrueba2, 10, "DABC");

        Concierto concierto1 = new Concierto("Bon Jovi", LocalDate.of(2026, 5,10), recintoPrueba2, 15, "EVT-123-ABC", "BonJovi",500);
        Concierto concierto2 = new Concierto("HannahMontana", LocalDate.of(2026, 8, 10), recintoPrueba4, 20, "EVT-456-ZXC", "HannahMontana", 750);
        Partido partido1 = new Partido("Malaga/Barcelona", LocalDate.of(2026, 4, 12), recintoPrueba3, 35, "EVT-321-CBA","Malaga", "Barcelona", 750, 3000);
        Partido partido2 = new Partido("Villareal/Valencia", LocalDate.of(2026, 3, 12), recintoPrueba3, 20, "EVT-654-CXZ", "VillarealFC", "ValenciaFC", 750, 1750);



    /*
        System.out.println(partido1.obtenerCodigoReferencia());
        System.out.println(concierto1.obtenerCodigoReferencia());
        System.out.println(partido1.calcularCosteOperativo());
        System.out.println(concierto1.calcularCosteOperativo());
        servicioEvento.registrarEvento(partido1);
        servicioEvento.registrarEvento(concierto1);
        servicioEvento.registrarEvento(concierto2);
        servicioEvento.registrarEvento(partido2);
        servicioEvento.generarInformeFinanciero();

     */
        /*
        //CREACION DEL EVENTO
        System.out.println("---CREACION EVENTO---");
        System.out.println("Introduce nombre del evento: ");
        String nombreEvento = teclado.nextLine();
        System.out.println("Introduce Año del evento: ");
        int year = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el mes del evento: ");
        int mes = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el dia del evento: ");
        int dia = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce un codigo valido");
        String codigo = teclado.nextLine();
        while(!UtilidadValidacion.esCodigoEventoValido(codigo)){
            System.out.println("Introduce un codigo valido");
            codigo = teclado.nextLine();
        }
        System.out.println("Introduce Precio: ");
        int precio = teclado.nextInt();
        teclado.nextLine();
        //evento2 = new Evento(nombreEvento,LocalDate.of(year,mes,dia),recintoPrueba, precio, codigo);
        //servicioEvento.registrarEvento(evento2);
*/
        Usuario Pau;
        Usuario Junfeng  = new Usuario("Junfeng", "junfeng@mail.com", true);
        Usuario Maria = new Usuario("Maria", "maria@mail.com", false);
        Usuario Terminator  = new Usuario("Terminator", "terminator@mail.com", false);



        //CREACION DE USUARIO
        System.out.println("---CREACION USUARIO----");
        System.out.println("Introduce nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduce Email: ");
        String mail = teclado.nextLine();
        while(!UtilidadValidacion.esEmailValido(mail)){
            System.out.println("Introduce Email: ");
            mail = teclado.nextLine();
        }
        System.out.println("Eres vip");
        boolean esVIP = teclado.nextBoolean();
        teclado.nextLine();
        Pau = new Usuario(nombre, mail, esVIP);
        servicioUsuario.registrarUsuario(Pau);
        Usuario pau2 = new Usuario("pau2", "pau@mail.com", true);
        servicioUsuario.registrarUsuario(pau2);

        // TICKET
        Ticket ticket = new Ticket(partido1, Pau);
        Ticket ticket2 = new Ticket(concierto1, Junfeng);

        DetallePago pago = new DetallePago("VISA", "123457");
        Pau.añadirDetallePago(pago);
        pago.realizarPago(250, "VISA");


        listaMezclada.add(Pau);
        listaMezclada.add(concierto1);
        listaMezclada.add(partido1);
        listaMezclada.add(ticket);
        UtilidadExportacion.exportarLista(listaMezclada);

        PagoTarjeta pago1 = new PagoTarjeta("123456789", "05/27");
        pago1.procesarPago(50);



        /*     Concierto conciertoPrueba = new Concierto("conciertoPrueba", LocalDate.of(2025,12,05), recintoPrueba,20, "My Chemical Romance" );
             conciertoPrueba.getNombre();
             conciertoPrueba.consultarBandaPrincipal();
             conciertoPrueba.mostrarInformacion();

             //PARTIDO
             Partido partidoPrueba = new Partido("Villareal/Betis", LocalDate.now(), recintoPrueba, 20, "Villareal FC", "Real Betis FC");
             partidoPrueba.getNombre();
             partidoPrueba.consultarEquipoLocal();
             partidoPrueba.consultarEquipoVisitante();
             partidoPrueba.mostrarInformacion();*/

        /*
        recintoPrueba.reservarAsientoVip(1);
        recintoPrueba.reservarAsientoVip(5);
        recintoPrueba.reservarAsientoVip(10);
        recintoPrueba.consultarAsientosVip();
        System.out.println(recintoPrueba.contarAsientosVipLibres());
        //servicioEvento.registrarEvento(fdl);

        //servicioEvento.registrarEvento(evento3);
        //servicioEvento.registrarEvento(evento4);
        //servicioEvento.registrarEvento(evento5);

        servicioUsuario.registrarUsuario(Maria);
        servicioUsuario.registrarUsuario(Junfeng);
        servicioUsuario.registrarUsuario(Terminator);
        servicioEvento.mostrarTodosEventos();
        recintoPrueba.mostrarInformacion();

        //servicioEvento.eliminarEventosPasados();
        //servicioEvento.buscarDestacadoMasCaro().mostrarInformacion();
        System.out.println("---Verificaciones STREAMS---");
        System.out.println("--BUSCANDO EVENTO--");
        System.out.println(servicioEvento.buscarEvento("feria castellon"));
        System.out.println("--AFORO CAPACIDAD ALTA--");
        System.out.println(servicioEvento.obtenerEventosConAforoMayor(100));
        System.out.println("--USUARIOS VIPS--");
        servicioUsuario.mostrarUsuarios();
        servicioUsuario.imprimirVips();
        System.out.println("--EVENTOS BENEFICOS--");
        System.out.println(servicioEvento.contarEventosBeneficos());
        System.out.println("----BUSCAR POR NOMBRE----");
        servicioUsuario.buscarPorNombre("Pau");
        System.out.println("---CUANTOS EVENTOS SUPERAN EL AFORO MINIMO---");
        System.out.println(servicioEvento.contarEventosPorAforo(100));
        System.out.println("----VALIDACIONES----");

*/    }




}
