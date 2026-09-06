package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import domain.Endereco;
import domain.Pet;
import domain.Sexo;
import domain.TipoPet;

public class BuscarPets {
    public static Pet[] lerPetArquvio() {
        File pastaPet = new File("petsCadastrados");
        File[] listFiles = pastaPet.listFiles();
        Pet[] listaPets = new Pet[listFiles.length];
        int i = 0;
        for (File petFile : listFiles) {

            Pet pet1 = new Pet();
            Endereco pEndereco = new Endereco();
            int c = 0;
            try (FileReader fr = new FileReader(petFile);
                    BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    int indexOf = linha.indexOf(" - ");
                    String substring = linha.substring(indexOf + 3);
                    String[] split = substring.split(",");
                    c++;
                    switch (c) {
                        case 1:
                            pet1.setNome(substring);
                            break;
                        case 2:
                            if (substring.equals("GATO")) {
                                pet1.setTipoPet(TipoPet.GATO);
                            } else {
                                pet1.setTipoPet(TipoPet.CACHORRO);
                            }
                            break;
                        case 3:
                            if (substring.equals("MASCULINO")) {
                                pet1.setSexo(Sexo.MASCULINO);
                            } else {
                                pet1.setSexo(Sexo.FEMININO);
                            }
                            break;
                        case 4:
                            pEndereco.setRua(split[0]);
                            pEndereco.setNumeroCasa(split[1]);
                            pEndereco.setCidade(split[2]);
                            pet1.setEndereco(pEndereco);
                            break;
                        case 5:
                            pet1.setIdade(substring);
                            break;
                        case 6:
                            pet1.setPeso(substring);
                            break;
                        case 7:
                            pet1.setRaca(substring);
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            listaPets[i] = pet1;
            i++;
        }
        return listaPets;
    }
}
