package models;

public class Reserva {
    private Passageiro passageiro;
    private Voo voo;
    private boolean confirmada;

    public Reserva(Passageiro passageiro, Voo voo) {
        this.passageiro = passageiro;
        this.voo = voo;
        this.confirmada = false;
    }

    public Passageiro getPassageiro() { return passageiro; }
    public Voo getVoo() { return voo; }
    public boolean isConfirmada() { return confirmada; }
    public void confirmar() { this.confirmada = true; }

    @Override
    public String toString() {
        String status = confirmada ? "Confirmada" : "Pendente";
        return "Reserva de " + passageiro.getNome() + " para o voo " + voo.getNumero() + " - " + status;
    }
}
