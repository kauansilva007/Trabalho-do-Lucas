package models;

public class Passageiro {
    private String nome;
    private int idade;
    private String cpf;
    private String email;

    public Passageiro(String nome, int idade, String cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}
