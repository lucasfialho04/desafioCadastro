package service;

import java.util.Scanner;

public  class  Menu {
    public static  int menu() {
        Scanner input = new Scanner(System.in);
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
}
