package org.example;

import org.example.model.Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizzaria {

    static ArrayList<Restaurante> restaurantes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirNomeDoPrograma();
        exibirOpcoes();
        escolherOpcao();
    }

    public static void exibirNomeDoPrograma() {
        System.out.println("Pizzaria do Professor Diogo\n");
    }

    public static void exibirOpcoes() {
        System.out.println("1. Cadastrar restaurante");
        System.out.println("2. Listar restaurantes");
        System.out.println("3. Alternar estado do restaurante");
        System.out.println("4. Sair\n");
    }

    public static void escolherOpcao() {
        int opcaoEscolhida;
        try {
            opcaoEscolhida = Integer.parseInt(scanner.nextLine());

            switch (opcaoEscolhida) {
                case 1:
                    cadastrarNovoRestaurante();
                    break;
                case 2:
                    listarRestaurantes();
                    break;
                case 3:
                    alternarEstadoRestaurante();
                    break;
                case 4:
                    finalizarApp();
                    break;
                default:
                    opcaoInvalida();
            }
        } catch (NumberFormatException e) {
            opcaoInvalida();
        }
    }

    public static void cadastrarNovoRestaurante() {
        System.out.println("Cadastro de novos restaurantes");
        System.out.print("Digite o nome do restaurante que deseja cadastrar: ");
        String nomeDoRestaurante = scanner.nextLine();
        System.out.print("Digite o nome da categoria do restaurante " + nomeDoRestaurante + ": ");
        String categoria = scanner.nextLine();
        Restaurante novoRestaurante = new Restaurante(nomeDoRestaurante, categoria, false);
        restaurantes.add(novoRestaurante);
        System.out.println("O restaurante " + nomeDoRestaurante + " foi cadastrado com sucesso!\n");
        voltarAoMenuPrincipal();
    }

    public static void listarRestaurantes() {
        System.out.println("\nListando restaurantes");
        System.out.printf("%-22s | %-20s | Status\n", "Nome do restaurante", "Categoria");
        for (Restaurante restaurante : restaurantes) {
            String ativo = restaurante.isAtivo() ? "ativado" : "desativado";
            System.out.printf("- %-20s | %-20s | %s\n", restaurante.getNome(), restaurante.getCategoria(), ativo);
        }
        voltarAoMenuPrincipal();
    }

    public static void alternarEstadoRestaurante() {
        System.out.println("\nAlterando estado do restaurante");
        System.out.print("Digite o nome do restaurante que deseja alterar o estado: ");
        String nomeRestaurante = scanner.nextLine();
        boolean restauranteEncontrado = false;
        for (Restaurante restaurante : restaurantes) {
            if (nomeRestaurante.equals(restaurante.getNome())) {
                restauranteEncontrado = true;
                restaurante.setAtivo(!restaurante.isAtivo());
                String mensagem = restaurante.isAtivo() ? "ativado" : "desativado";
                System.out.println("O restaurante " + nomeRestaurante + " foi " + mensagem + " com sucesso.");
            }
        }
        if (!restauranteEncontrado) {
            System.out.println("O restaurante não foi encontrado");
        }
        voltarAoMenuPrincipal();
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida!\n");
        voltarAoMenuPrincipal();
    }

    public static void finalizarApp() {
        System.out.println("\nFinalizar app");
        // Implemente aqui a lógica para finalizar o aplicativo, se necessário
    }

    public static void voltarAoMenuPrincipal() {
        System.out.print("\nDigite uma tecla para voltar ao menu: ");
        scanner.nextLine(); // Aguarda o usuário pressionar Enter para continuar
        System.out.println();
        exibirOpcoes();
        escolherOpcao();
    }
}

