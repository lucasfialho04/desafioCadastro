package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import domain.Pet;

public class SalvarPet {
    public static void salvarPet(Pet pet1) {
        LocalDateTime dataHoje = LocalDateTime.now();
        File pastaPet = new File("petsCadastrados");
        pastaPet.mkdir();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String format = dataHoje.format(dataFormatada);
        String nomePet = pet1.getNome().toUpperCase().replace(" ", "");
        String nomeFinal = format + "-" + nomePet + ".txt";
        File arquivoPet = new File(pastaPet, nomeFinal);
        try (OutputStreamWriter osw = new OutputStreamWriter(new java.io.FileOutputStream(arquivoPet, true),
                StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(1 + " - " + pet1.getNome());
            bw.newLine();
            bw.write(2 + " - " + pet1.getTipoPet());
            bw.newLine();
            bw.write(3 + " - " + pet1.getSexo());
            bw.newLine();
            bw.write(4 + " - " + pet1.getEndereco().getRua() + "," + pet1.getEndereco().getNumeroCasa() + ","
                    + pet1.getEndereco().getCidade());
            bw.newLine();
            bw.write(5 + " - " + pet1.getIdade());
            bw.newLine();
            bw.write(6 + " - " + pet1.getPeso());
            bw.newLine();
            bw.write(7 + " - " + pet1.getRaca());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
