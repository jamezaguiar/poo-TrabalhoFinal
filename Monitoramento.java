package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Random;

public class Monitoramento {

    public static Map<Integer, Veiculo> veiculos = new TreeMap<>(); // Mapa de veículos
    public static Map<String, Usuario> usuarios = new TreeMap<>(); // Mapa de usuários
    public static ArrayList<Cidade> cidades = new ArrayList(); // ArrayList de cidades monitoradas
    public static ArrayList<Integer> senhas = new ArrayList(); // ArrayList usado para que as senhas dos veículos não se repitam
    Random r = new Random(); // Objeto random para gerar números aleatórios



    
    // Método para registro de usuários
    public void registrarUsuario(String nome, String cpf) throws UsuarioJaExisteException {
        if (usuarios.containsKey(cpf)) {
            throw new UsuarioJaExisteException();
        } else {
            Usuario usuario = new Usuario(nome, cpf);
            usuarios.put(cpf, usuario);
            System.out.println("done");
        }
    }

    // Método para registro de veículos, especificamente do tipo Caminhão, aqui foi utilizado o polimorfismo de sobrecarga
    public void registraVeiculo(String cpf, String tipo, String carga, String marca, String cor, String placa, int ano) {
        Veiculo v;
        if (usuarios.containsKey(cpf)) {
            switch (tipo) {
                case "caminhao":
                    boolean cargaRes;
                    if (carga.equals("sim")) {
                        cargaRes = true;
                    } else {
                        cargaRes = false;
                    }
                    v = new Caminhao(cargaRes, marca, cor, placa, ano);
                    v.setSenha(gerarSenha()); // Senha gerada pelo método gerarSenha() é setada na variável senha do veículo
                    veiculos.put(v.getSenha(), v);
                    System.out.println("Senha para controle deste veículo: " + v.getSenha());
                    System.out.println("done");
                    break;
                default:
                    System.out.println("Tipo inválido de veículo, tente -carro-, -moto- ou -caminhao-.");
                    break;
            }
        } else {
            System.out.println("Não existe usuário com o CPF informado, tente novamente.");
        }
    }

    public void registraVeiculo(String cpf, String tipo, String marca, String cor, String placa, int ano) {
        Veiculo v;
        if (usuarios.containsKey(cpf)) {
            switch (tipo) {
                case "carro":
                    v = new Carro(marca, cor, placa, ano);
                    v.setSenha(gerarSenha()); // Senha gerada pelo método gerarSenha() é setada na variável senha do veículo
                    veiculos.put(v.getSenha(), v);
                    System.out.println("Senha para controle deste veículo: " + v.getSenha());
                    System.out.println("done");
                    break;
                case "moto":
                    v = new Moto(marca, cor, placa, ano);
                    v.setSenha(gerarSenha()); // Senha gerada pelo método gerarSenha() é setada na variável senha do veículo
                    veiculos.put(v.getSenha(), v);
                    System.out.println("Senha para controle deste veículo: " + v.getSenha());
                    System.out.println("done");
                    break;
                default:
                    System.out.println("Erro na passagem de parâmetros, tente novamente.");
                    break;
            }
        } else {
            System.out.println("Não existe usuário com o CPF informado, tente novamente.");
        }
    }

    // Método para travar veículo
    public static void travarVeiculo(int senha) throws VeiculoNaoExisteException {
        if (veiculos.get(senha) == null) {
            throw new VeiculoNaoExisteException();
        } else {
            veiculos.get(senha).setTravado(true);
            veiculos.get(senha).setLigado(false);
            veiculos.get(senha).setAndando(false);
            veiculos.get(senha).setVelocidadeAtual(0.0f);
            System.out.println("done");
        }
    }

    // Método para destravar veículo
    public static void destravarVeiculo(int senha) throws VeiculoNaoExisteException {
        if (veiculos.get(senha) == null) {
            throw new VeiculoNaoExisteException();
        } else {
            veiculos.get(senha).setTravado(false);
            System.out.println("done");
        }
    }

    // Método que mostra as informações do veículo
    public void informacoesDoVeiculo(int senha) throws VeiculoNaoExisteException {
        if (veiculos.get(senha) == null) {
            throw new VeiculoNaoExisteException();
        } else {
            String saida = veiculos.get(senha).toString();
            System.out.println(saida);
        }
    }

    // Método que mostra as informações do usuário
    public void informacoesDoUsuario(String cpf) throws UsuarioNaoExisteException {
        if (usuarios.get(cpf) == null) {
            throw new UsuarioNaoExisteException();
        } else {
            String saida = usuarios.get(cpf).toString();
            System.out.println(saida);
        }
    }

    // Método para gerar senhas aleatórias usadas para controle dos veículos
    public int gerarSenha() {
        int senha;

        senha = r.nextInt(2147483647); // Este número corresponde ao maior número que cabe numa variável do tipo int

        while (true) {
            if (senhas.isEmpty()) {
                senhas.add(senha);
                break;
            } else if (senhas.contains(senha)) {
                senha = r.nextInt(2147483647);
            } else {
                senhas.add(senha);
                break;
            }
        }

        return senha;
    }
}
