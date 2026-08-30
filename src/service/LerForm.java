package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LerForm {
    public static  void lerForm(){
          File file = new File("formulario.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String linha;
            while ((linha = br.readLine()) != null) {

                System.out.println(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
