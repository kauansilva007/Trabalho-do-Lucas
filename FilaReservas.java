package controllers;

import java.util.LinkedList;
import java.util.Queue;
import models.Reserva;

public class FilaReservas {
    private Queue<Reserva> fila;

    public FilaReservas() {
        fila = new LinkedList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        fila.add(reserva);
    }

    public Reserva proximaReserva() {
        return fila.poll();
    }

    public boolean temReservas() {
        return !fila.isEmpty();
    }

    public Queue<Reserva> listarReservas() {
        return fila;
    }
}
