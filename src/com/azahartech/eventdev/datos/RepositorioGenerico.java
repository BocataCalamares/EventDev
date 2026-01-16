package com.azahartech.eventdev.datos;

import java.util.ArrayList;

public class RepositorioGenerico<T> {
    //ATRIBUTOS
    private ArrayList<T> elementos = new ArrayList<>();

    //METODOS
    //Guardar Elemento
    public void guardar(T objeto){
        elementos.add(objeto);
    }
    //Listar Elementos
    public ArrayList<T> listar(){
        return elementos;
    }
    //Eliminar elementos
    public void eliminar(T objeto){
        elementos.remove(objeto);
    }
    //Obtener un elemento concreto
    public T obtener(int posicion){
        return elementos.get(posicion);
    }
    //Devolver tamaño
    public int tamaño(){
        return elementos.size();
    }


}
