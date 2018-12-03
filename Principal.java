package exec;

import model.Monitoramento;
import model.UsuarioJaExisteException;
import java.util.Scanner;
import model.Cidade;
import model.UsuarioNaoExisteException;
import model.VeiculoNaoExisteException;

public class Principal {

    public static Monitoramento m = new Monitoramento();

    public static void main(String[] args) {
        // Cidades monitoradas
        Cidade c1 = new Cidade("Ocara");
        Cidade c2 = new Cidade("Pacajus");
        Cidade c3 = new Cidade("Quixadá");
        Cidade c4 = new Cidade("Chorozinho");
        Cidade c5 = new Cidade("Ibaretama");
        Cidade c6 = new Cidade("Quixeramobim");
        Cidade c7 = new Cidade("Fortaleza");
        Cidade c8 = new Cidade("Horizonte");
        Cidade c9 = new Cidade("Sen. Pompeu");
        Cidade c10 = new Cidade("Pedra Branca");
        Monitoramento.cidades.add(c1);
        Monitoramento.cidades.add(c2);
        Monitoramento.cidades.add(c3);
        Monitoramento.cidades.add(c4);
        Monitoramento.cidades.add(c5);
        Monitoramento.cidades.add(c6);
        Monitoramento.cidades.add(c7);
        Monitoramento.cidades.add(c8);
        Monitoramento.cidades.add(c9);
        Monitoramento.cidades.add(c10);
        
        String comando;
        String comandos[];
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\tSistema de Monitoramento de Veículos");
        String instrucoes = "======================================================================================INSTRUÇÕES======================================================================================\n"
                + "registrarUsuario (nome) (cpf): Registra um usuário no sistema de monitoramento\n"
                + "registrarVeiculo (cpf) (tipo) (carga) (marca) (cor) (placa) (ano): Registra um veículo no sistema e retorna a senha de monitoramento(NÃO USE CARGA SE SEU VEÍCULO NÃO FOR UM CAMINHÃO)\n"
                + "solicitarTrava (senha): Trava o veículo com a senha correspondente\n"
                + "solicitarDestrava (senha): Destrava o veículo com a senha correspondente\n"
                + "informacoesDoUsuario (cpf): Mostra os dados do usuário com o CPF correspondente\n"
                + "informacoesDoVeiculo (senha): Mostra informações e estado atual do veículo com a senha correspondente\n"
                + "sair: Desliga controle de monitoramento\n";
        System.out.println(instrucoes);

        while (true) {
            System.out.print("Digite um comando: ");
            // Bloco for simula o movimento dos veículos através do método andar
            for (int vk : Monitoramento.senhas) {
                if (Monitoramento.veiculos.get(vk).isTravado()) {
                    continue;
                } else {
                    Monitoramento.veiculos.get(vk).andar();
                }
            }
            comando = input.nextLine();
            comandos = comando.split(" ");
            if (comandos[0].equals("sair")) {
                System.out.println("Desligando controle de monitoramento...");
                break;
            } else {
                switch (comandos[0]) {
                    case "registrarUsuario":
                        try {
                            m.registrarUsuario(comandos[1], comandos[2]);
                        } catch (UsuarioJaExisteException ex) {
                            System.out.println("Usuário já existe");
                        }
                        break;
                    case "registrarVeiculo":
                        switch (comandos.length) {
                            case 7:
                                m.registraVeiculo(comandos[1], comandos[2], comandos[3], comandos[4], comandos[5], Integer.parseInt(comandos[6]));
                                break;
                            case 8:
                                m.registraVeiculo(comandos[1], comandos[2], comandos[3], comandos[4], comandos[5], comandos[6], Integer.parseInt(comandos[7]));
                                break;
                            default:
                                System.out.println("Informações insuficientes, tente novamente.");
                                break;
                        }
                        break;
                    case "solicitarTrava":
                        try {
                            Monitoramento.travarVeiculo(Integer.parseInt(comandos[1]));
                        } catch (VeiculoNaoExisteException ex) {
                            System.out.println("Não existe veículo correspondente a senha informada, tente novamente.");
                        }
                        break;
                    case "solicitarDestrava":
                        try {
                            Monitoramento.destravarVeiculo(Integer.parseInt(comandos[1]));
                        } catch (VeiculoNaoExisteException ex) {
                            System.out.println("Não existe veículo correspondente a senha informada, tente novamente.");
                        }
                        break;
                    case "informacoesDoUsuario":
                        try {
                            m.informacoesDoUsuario(comandos[1]);
                        } catch (UsuarioNaoExisteException ex) {
                            System.out.println("Não existe usuário com o CPF informado, tente novamente.");
                        }
                        break;
                    case "informacoesDoVeiculo":
                        try {
                            m.informacoesDoVeiculo(Integer.parseInt(comandos[1]));
                        } catch (VeiculoNaoExisteException ex) {
                            System.out.println("Não existe veículo correspondente a senha informada, tente novamente.");
                        }
                        break;
                    default:
                        System.out.println("Comando inválido, tente novamente.");
                        break;
                }
            }
        }
    }
}
