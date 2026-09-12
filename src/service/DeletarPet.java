package service;

import java.io.File;
import java.util.List;

import domain.Pet;

public class DeletarPet {
    public  static Pet deletarPet(){
        
        Pet  pet = null;
        int v = 0;
        List<Pet> buscarEexibir = BuscarPets.buscarEexibir();
        String petParaDeletar;
        System.out.println("qual pet voce quer deletar? ");
        petParaDeletar = Menu.input.nextLine();
        try {
            v = Integer.parseInt(petParaDeletar) - 1;
             pet = buscarEexibir.get(v);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("pet nao encontrado");
        }
        return pet;
    }
    public static void deletandoPet (){
        boolean delete = false;
        Pet pet = deletarPet();
        System.out.println("tem certeza disso? s/n");
        String r = Menu.input.nextLine();
        File filePet = new File("petsCadastrados",pet.getNomeArquivoPet());
        if (r.equalsIgnoreCase("s")) {
            try {
          delete =  filePet.delete();
            if (delete) {
                System.out.println("Pet deletado com sucesso ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
}
