package model;

public class Cidade {

    private String nome;

    public Cidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }
}
