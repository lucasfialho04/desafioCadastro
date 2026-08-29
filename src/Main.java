import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new  File("formulario.txt");
        try (FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(fr);) {
               String linha;
            while ((linha = br.readLine()) != null) {
             
                System.out.println(linha);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        int int1=0;
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
         int1 = Integer.parseInt(opcao); 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("numero invalido");
            int1 = -1;
        }
        
       }      while (!(int1 >0) || !(int1<7) );
    }
}
