package controllers;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class SistemaAeroporto {
    private List<Voo> voos;
    private FilaReservas filaReservas;
    private PilhaCheckin pilhaCheckin;

    public SistemaAeroporto() {
        voos = new ArrayList<>();
        filaReservas = new FilaReservas();
        pilhaCheckin = new PilhaCheckin();
    }

    public void adicionarVoo(String numero, String origem, String destino, String partida, String chegada, int capacidade, boolean internacional) {
        voos.add(new Voo(numero, origem, destino, partida, chegada, capacidade, internacional));
    }

    public void listarVoos() {
        System.out.println("\n===== LISTA DE TODOS OS VOOS =====");
        for (Voo voo : voos) {
            System.out.println(voo);
        }
    }

    public void listarVoosInternacionais() {
        System.out.println("\n===== VOOS INTERNACIONAIS =====");
        boolean encontrou = false;
        for (Voo voo : voos) {
            if (voo.isInternacional()) {
                System.out.println(voo);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum voo internacional encontrado.");
    }

    public void reservarVoo(String numeroVoo, String nome, int idade, String cpf, String email) {
        Voo voo = buscarVoo(numeroVoo);
        if (voo == null) {
            System.out.println("Voo não encontrado.");
            return;
        }
        if (voo.estaCheio()) {
            System.out.println("Voo está cheio!");
            return;
        }

        Passageiro passageiro = new Passageiro(nome, idade, cpf, email);
        Reserva reserva = new Reserva(passageiro, voo);
        filaReservas.adicionarReserva(reserva);
        voo.getReservasPendentes().add(reserva);
        System.out.println("Reserva adicionada à fila de pendentes.");
    }

    public void processarReservas() {
        if (!filaReservas.temReservas()) {
            System.out.println("Nenhuma reserva pendente.");
            return;
        }

        Reserva reserva = filaReservas.proximaReserva();
        Voo voo = reserva.getVoo();

        if (voo.vagasDisponiveis() > 0) {
            reserva.confirmar();
            voo.getReservasConfirmadas().add(reserva);
            System.out.println("Reserva confirmada para " + reserva.getPassageiro().getNome() + " no voo " + voo.getNumero());
        } else {
            System.out.println("Voo " + voo.getNumero() + " está cheio. Reserva não confirmada.");
        }
    }

    public void realizarCheckin(String cpf) {
        for (Voo voo : voos) {
            for (Reserva reserva : voo.getReservasConfirmadas()) {
                if (reserva.getPassageiro().getCpf().equals(cpf)) {
                    pilhaCheckin.realizarCheckin(reserva.getPassageiro());
                    System.out.println("Check-in realizado para " + reserva.getPassageiro().getNome());
                    return;
                }
            }
        }
        System.out.println("Passageiro não encontrado ou reserva não confirmada.");
    }

    public void exibirVoos() {
        System.out.println("\n--- Voos Disponíveis ---");
        for (Voo voo : voos) {
            if (!voo.estaCheio()) System.out.println(voo);
        }

        System.out.println("\n--- Voos com Reservas Pendentes ---");
        for (Voo voo : voos) {
            if (!voo.getReservasPendentes().isEmpty())
                System.out.println("Voo " + voo.getNumero() + ": " + voo.getReservasPendentes().size() + " pendentes");
        }

        System.out.println("\n--- Voos Cheios ---");
        for (Voo voo : voos) {
            if (voo.estaCheio())
                System.out.println("Voo " + voo.getNumero() + " está cheio.");
        }
    }

    private Voo buscarVoo(String numero) {
        for (Voo voo : voos) {
            if (voo.getNumero().equals(numero))
                return voo;
        }
        return null;
    }
}
