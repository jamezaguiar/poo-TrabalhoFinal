package model;

public class Carro extends Veiculo {

    public Carro(String marca, String cor, String placa, int ano) {
        super(marca, cor, placa, ano);
    }

    @Override
    public String toString() {
        String info = "";
        info += "\n=CARRO=\n";
        info += super.toString();

        return info;
    }
}
