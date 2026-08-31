package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class LerForm {
    public static String[] lerForm() {
        Scanner input = new Scanner(System.in);
        File file = new File("formulario.txt");
        int c = 0;
        String[] arrayRespostas = new String[7];
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String linha;
            while ((linha = br.readLine()) != null) {

                System.out.println(linha);
                arrayRespostas[c] = input.nextLine();
                c++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayRespostas;
    }
}
