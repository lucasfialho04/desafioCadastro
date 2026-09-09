package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LerForm {
    public static String[] lerForm() {
        
        File file = new File("formulario.txt");
        int c = 0;
        String[] arrayRespostas = new String[7];
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String linha;
            while ((linha = br.readLine()) != null) {

                System.out.println(linha);
                arrayRespostas[c] = Menu.input.nextLine();
                c++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayRespostas;
    }
}
