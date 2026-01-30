package com.azahartech.eventdev.util;

import java.util.List;

public class UtilidadExportacion {
    public static void exportarLista(List<Exportable> listaObjetos){
        for(Exportable Objeto : listaObjetos){
            System.out.println(Objeto.aCSV());
            System.out.println(Objeto.aXML());
        }
    }
}
