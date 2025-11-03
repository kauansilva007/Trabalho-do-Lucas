package models;

import java.util.ArrayList;
import java.util.List;

public class Voo {
    private String numero;
    private String origem;
    private String destino;
    private String partida;
    private String chegada;
    private int capacidadeMax;
    private boolean internacional;
    private List<Reserva> reservasConfirmadas;
    private List<Reserva> reservasPendentes;

    public Voo(String numero, String origem, String destino, String partida, String chegada, int capacidadeMax, boolean internacional) {
        if (!numero.matches("\\d{4}")) {
            throw new IllegalArgumentException("O número do voo deve conter 4 dígitos.");
        }
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.partida = partida;
        this.chegada = chegada;
        this.capacidadeMax = capacidadeMax;
        this.internacional = internacional;
        this.reservasConfirmadas = new ArrayList<>();
        this.reservasPendentes = new ArrayList<>();
    }

    public String getNumero() { return numero; }
    public boolean isInternacional() { return internacional; }
    public int getCapacidadeMax() { return capacidadeMax; }
    public List<Reserva> getReservasConfirmadas() { return reservasConfirmadas; }
    public List<Reserva> getReservasPendentes() { return reservasPendentes; }

    public boolean estaCheio() {
        return reservasConfirmadas.size() >= capacidadeMax;
    }

    public int vagasDisponiveis() {
        return capacidadeMax - reservasConfirmadas.size();
    }

    @Override
    public String toString() {
        String tipo = internacional ? "🌍 Internacional" : "🇧🇷 Nacional";
        return String.format("%s | Voo %s | %s -> %s | Partida: %s | Chegada: %s | Vagas: %d",
                tipo, numero, origem, destino, partida, chegada, vagasDisponiveis());
    }
}
