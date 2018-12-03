package model;

import java.util.Random;

public abstract class Veiculo {

    Random r = new Random();
    Random l = new Random();

    protected String marca;
    protected String cor;
    protected String placa;
    protected int ano;
    protected boolean travado;
    protected boolean ligado;
    protected boolean andando;
    protected double velocidadeAtual;
    protected int senha;
    protected Cidade localizacao;

    public Veiculo(String marca, String cor, String placa, int ano) {
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.ano = ano;
        this.travado = false;
        this.ligado = false;
        this.andando = false;
        this.velocidadeAtual = 0.0f;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isTravado() {
        return travado;
    }

    public void setTravado(boolean travado) {
        this.travado = travado;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isAndando() {
        return andando;
    }

    public void setAndando(boolean andando) {
        this.andando = andando;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = Math.ceil(velocidadeAtual); // Velocidade atual do veículo é arredondada para cima, já que o random em float gera muitas casas decimais
    }

    public Cidade getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(Cidade localizacao) {
        this.localizacao = localizacao;
    }

    /* Método para ligar veículo não utilizado
    public void ligarVeiculo() {
        if (travado) {
            System.out.println("O veículo está travado!");
        } else {
            this.ligado = true;
        }
    }*/

    // Método para simular o movimento dos veículos
    public void andar() {
        setVelocidadeAtual(r.nextDouble() * 120); // Veículos trafegam no máximo a 120KM/h
        setAndando(true);
        setLigado(true);
        setLocalizacao(Monitoramento.cidades.get(l.nextInt(9)));
    }

    /* Método para parar os veículos (não utilizado)
    public void parar() {
        setVelocidadeAtual(0.0);
        setAndando(false);
        setLigado(false);
    }*/
    @Override
    public String toString() {
        String info = "";

        info += "Marca: " + this.marca + "\n"
                + "Cor: " + this.cor + "\n"
                + "Placa: " + this.placa + "\n"
                + "Ano: " + this.ano + "\n"
                + "Está travado?: ";
        info += (this.travado) ? "Sim" + "\n" : "Não" + "\n";
        info += "Está ligado?: ";
        info += (this.ligado) ? "Sim" + "\n" : "Não" + "\n";
        info += "Está andando?: ";
        info += (this.andando) ? "Sim" + "\n" : "Não" + "\n";
        info += "Velocidade Atual: " + this.velocidadeAtual + "KM/h\n";
        info += "Cidade Atual: " + localizacao.getNome() + "\n";

        return info;
    }
}
