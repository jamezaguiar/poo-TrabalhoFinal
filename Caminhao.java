package model;

public class Caminhao extends Veiculo {

    protected boolean carga;

    public Caminhao(boolean carga, String marca, String cor, String placa, int ano) {
        super(marca, cor, placa, ano);
        this.carga = carga;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        String info = "";
        info += "\n=CAMINHÃO=\n";
        info += super.toString();
        info += "Está carregado?: ";
        info += (this.carga) ? "Sim" + "\n" : "Não" + "\n";

        return info;
    }

}
