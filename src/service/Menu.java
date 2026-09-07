package service;

import java.util.Scanner;

public class Menu {
    public static int menu() {
        Scanner input = new Scanner(System.in, "UTF-8");
        int opcaoEscolhida = 0;
        String opcao;

        do {
            System.out.println("---------MENU--------");
            System.out.println("Escolha uma das 6 opções abaixo : ");
            System.out.println("Opção 1 : Cadastrar um novo pet ");
            System.out.println("Opção 2 Alterar os dados do pet cadastrado ");
            System.out.println("Opção 3 Apagar um pet cadastrado ");
            System.out.println("Opção 4 Listar todos os animais de estimação cadastrados ");
            System.out.println("Opção 5  Listar pets por alguma classificação (idade, nome, raça) ");
            System.out.println("Opção 6 Sair ");

            try {
                opcao = input.nextLine();
                opcaoEscolhida = Integer.parseInt(opcao);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("numero invalido");
                opcaoEscolhida = -1;
            }

        } while (!(opcaoEscolhida > 0) || !(opcaoEscolhida < 7));
        return opcaoEscolhida;
    }

    public static int[] menu1() {
        Scanner input = new Scanner(System.in, "UTF-8");
        int[] opcaoEscolhida = new int[2];
        System.out.println("escolha 1 opcao");
        System.out.println("  Opção  1 - Nome\r\n" + //
                "  Opção  2 - Sexo\r\n" + //
                " Opção   3 - Idade\r\n" + //
                "  Opção  4 - Peso\r\n" + //
                " Opção   5 - Raça\r\n" + //
                " Opção   6 - Endereço");
        String opcao1 = input.nextLine();
        System.out.println(" deseja filtrar por mais uma opção? s/n");
        String r = input.nextLine();
        if (r.charAt(0) == 's') {
            System.out.println("qual outra voce quer?");
            String opcao2 = input.nextLine();
            try {
                int int2 = Integer.parseInt(opcao2);
                opcaoEscolhida[1] = int2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            int int1 = Integer.parseInt(opcao1);
            opcaoEscolhida[0] = int1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return opcaoEscolhida;
    }
}
