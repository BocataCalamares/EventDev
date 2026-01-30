package com.azahartech.eventdev.pagos;

public interface ProcesadorPago {
    abstract boolean procesarPago(double cantidad);
}
