package model;

import java.text.DateFormat;
import java.util.Date;

public class Usuario extends Pessoa {

    Date data = new Date(System.currentTimeMillis()); // Data atual do sistema
    String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data); // Data atual do sistema formatada

    protected String dataDeCadastro;

    public Usuario(String nome, String cpf) {
        super(nome, cpf);
        this.dataDeCadastro = dStr; // Variável dataDeCadastro recebe a data atual do sistema formatada
    }

    @Override
    public String toString() {
        String info = "";
        info += super.toString()
                + "Data de Cadastro: " + this.dataDeCadastro + "\n";
        return info;
    }
}
