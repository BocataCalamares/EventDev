package com.azahartech.eventdev.modelo;

public enum TipoEvento {
    CONCIERTO('C', "Musica en vivo"),
    TEATRO('T', "Obra Teatral en vivo"),
    DEPORTE('D', "Partido deportivo"),
    FESTIVAL('F', "Celebracion Festividades");

    //ATRIBUTOS
    final char codigo;
    final String descripcion;

    //METODOS
    //CONSTRUCTOR


    TipoEvento(char codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public char getCodigo() {
        return codigo;
    }
}
