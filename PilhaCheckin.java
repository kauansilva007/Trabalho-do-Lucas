package controllers;

import java.util.Stack;
import models.Passageiro;

public class PilhaCheckin {
    private Stack<Passageiro> pilha;

    public PilhaCheckin() {
        pilha = new Stack<>();
    }

    public void realizarCheckin(Passageiro passageiro) {
        pilha.push(passageiro);
    }

    public void listarCheckins() {
        System.out.println("--- Passageiros com check-in ---");
        for (int i = pilha.size() - 1; i >= 0; i--) {
            System.out.println(pilha.get(i));
        }
    }
}
