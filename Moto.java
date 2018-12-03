package model;

public class Moto extends Veiculo {

    public Moto(String marca, String cor, String placa, int ano) {
        super(marca, cor, placa, ano);
    }

    @Override
    public String toString() {
        String info = "";
        info += "\n=MOTO=\n";
        info += super.toString();

        return info;
    }
}
