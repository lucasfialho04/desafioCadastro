package main;

import service.CadastrarPet;
import service.Menu;

public class Main {
    public static void main(String[] args) {
       
        System.out.println(" ");
        int opcaoEscolhida = Menu.menu();
        switch (opcaoEscolhida) {
            case 1:
            CadastrarPet pet = new CadastrarPet();
            pet.cadastrar();
                break;
            case 2:

               break;
            case 3:

               break;
            case 4:

               break;
            case 5:

               break;
            case 6:

               break;
            default:
                break;
        }
    }
}
