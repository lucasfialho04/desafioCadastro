package main;

import service.BuscarPets;
import service.CadastrarPet;
import service.DeletarPet;
import service.Menu;

public class Main {
   public static void main(String[] args) {

      System.out.println(" ");
      int opcaoEscolhida = Menu.menu();
      while (opcaoEscolhida != 6) {

         switch (opcaoEscolhida) {
            case 1:
               CadastrarPet pet = new CadastrarPet();
               pet.cadastrar();
               break;
            case 2:
               BuscarPets.alterarFilePet();
               break;
            case 3:
               DeletarPet.deletandoPet();
               break;
            case 4:
               BuscarPets.exibirAllPets();
               break;
            case 5:
               BuscarPets.buscarEexibir();
               break;
            case 6:

               break;
            default:
               break;
         }
         opcaoEscolhida = Menu.menu();
      }
   }
}
