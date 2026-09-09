package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import domain.Endereco;
import domain.NaoInformado;
import domain.Pet;
import domain.Sexo;
import domain.TipoPet;

public class BuscarPets {
    public static void exibirAllPets() {
        Pet[] lerPetArquvio = lerPetArquvio();
        int c = 0;
        for (Pet pet : lerPetArquvio) {
            c++;
            System.out.println(c + ". " + pet.getNome() + " - " + pet.getTipoPet().toString() + " - "
                    + pet.getSexo().toString() + " - " + pet.getEndereco().getRua() + ", "
                    + pet.getEndereco().getNumeroCasa() + " - " + pet.getEndereco().getCidade() + " - " + pet.getIdade()
                    + " - " + pet.getPeso() + " - " + pet.getRaca());
        }
    }
    public static void alterarFilePet (){
        Pet petAlterado = alterarPet();
        LocalDateTime dataHoje = LocalDateTime.now();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String format = dataHoje.format(dataFormatada);
        String nomePet = petAlterado.getNome().toUpperCase().replace(" ", "");
        String nomeFinal = format + "-" + nomePet + ".txt";
        File file = new File("petsCadastrados",petAlterado.getNomeArquivoPet());
        File fileRenamed = new File("petsCadastrados",nomeFinal);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(1 + " - " + petAlterado.getNome());
            bw.newLine();
            bw.write(2 + " - " + petAlterado.getTipoPet());
            bw.newLine();
            bw.write(3 + " - " + petAlterado.getSexo());
            bw.newLine();
            bw.write(4 + " - " + petAlterado.getEndereco().getRua() + "," + petAlterado.getEndereco().getNumeroCasa() + ","
                    + petAlterado.getEndereco().getCidade());
            bw.newLine();
            bw.write(5 + " - " + petAlterado.getIdade());
            bw.newLine();
            bw.write(6 + " - " + petAlterado.getPeso());
            bw.newLine();
            bw.write(7 + " - " + petAlterado.getRaca());
            file.renameTo(fileRenamed);
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }

    } 
    public static Pet alterarPet() {
       String s;
        List<Pet> petsBuscados = buscarEexibir();
        Pet pet = null;
        Endereco enderecoPet = new Endereco();
        int r = 0;
        boolean encontrado = false;
        do {
            System.out.println("qual pet voce quer alterar? ");
            s = Menu.input.nextLine();
            r = Integer.parseInt(s) - 1;

            try {
                pet = petsBuscados.get(r);
                encontrado = true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("numero do pet nao existe ");
            }

        } while (encontrado == false);
        // System.out.println(pet.getNomeArquivoPet());
        int opcaoEscolhida = Menu.menuAlterar();
        
        switch (opcaoEscolhida) {
            case 1:
                System.out.println("digite o novo nome");
                String nome = Menu.input.nextLine();
                pet.setNome(nome);
                break;
            case 2:
                System.out.println("digite a nova idade");
                String idade = Menu.input.nextLine();
                pet.setIdade(idade);
                break;
            case 3:
                System.out.println("digite o novo Endereço");
                System.out.println("qual a rua?");
                enderecoPet.setRua(Menu.input.nextLine());
                System.out.println("qual o numero da casa?");
                enderecoPet.setNumeroCasa(Menu.input.nextLine());
                System.out.println("qual a cidade?");
                enderecoPet.setCidade(Menu.input.nextLine());
                pet.setEndereco(enderecoPet);
                break;
            case 4:
                System.out.println("digite o novo peso");
                String peso = Menu.input.nextLine();
                pet.setPeso(peso);
                break;
            case 5:
                System.out.println("digite a nova raça");
                String raca = Menu.input.nextLine();
                pet.setRaca(raca);
                break;
            default:
                break;
        }
            return pet;
    }


    public static List<Pet> buscarEexibir() {
        Pet[] lerPetArquvio = lerPetArquvio();
        String[] filtroPet = filtroPet();
        List<Pet> compararPets = compararPets(lerPetArquvio, filtroPet);
        int c = 0;
        for (Pet pet : compararPets) {
            c++;
            System.out.println(c + ". " + pet.getNome() + " - " + pet.getTipoPet().toString() + " - "
                    + pet.getSexo().toString() + " - " + pet.getEndereco().getRua() + ", "
                    + pet.getEndereco().getNumeroCasa() + " - " + pet.getEndereco().getCidade() + " - " + pet.getIdade()
                    + " - " + pet.getPeso() + " - " + pet.getRaca());
        }
        return compararPets;
    }

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
            pet1.setNomeArquivoPet(petFile.getName());
    
            listaPets[i] = pet1;
            i++;
        }
        return listaPets;
    }

    public static String[] filtroPet() {
        
        System.out.println(" qual o tipo do  pet que voce procura? cachorro/gato");
        String tipoPet = Menu.input.nextLine().toUpperCase();
        int[] menu1 = Menu.menu1();

        String[] informacao = new String[7];
        informacao[0] = tipoPet;
        for (int i : menu1) {

            switch (i) {
                case 1:
                    System.out.println("qual o nome?");
                    informacao[i] =  Menu.input.nextLine();
                    break;
                case 2:
                    System.out.println("qual o sexo? masculino/feminino");
                    informacao[i] =  Menu.input.nextLine().toUpperCase();
                    break;
                case 3:
                    System.out.println("qual a idade?");
                    informacao[i] =  Menu.input.nextLine();
                    break;
                case 4:
                    System.out.println("qual o peso?");
                    informacao[i] =  Menu.input.nextLine();
                    break;
                case 5:
                    System.out.println("qual a raça?");
                    informacao[i] =  Menu.input.nextLine();
                    break;
                case 6:
                    System.out.println("qual o endereço?");
                    informacao[i] =  Menu.input.nextLine();
                    break;
                default:
                    break;
            }

        }
        return informacao;
    }

    public static List<Pet> compararPets(Pet[] listaPets,
            String[] informacao) {
        List<Pet> listaPet = new ArrayList<>();

        for (Pet pet : listaPets) {
            boolean passou = true;
            if (!pet.getTipoPet().toString().contains(informacao[0])) {
                passou = false;
            }
            if (informacao[1] != null && !pet.getNome().toUpperCase().contains(informacao[1].toUpperCase())) {
                passou = false;
            }
            if (informacao[2] != null && !pet.getSexo().toString().contains(informacao[2])) {
                passou = false;
            }
            if (informacao[3] != null) {
                if (pet.getIdade().equals(NaoInformado.NAO_INFORMADO.toString())
                        || informacao[3].equals(NaoInformado.NAO_INFORMADO.toString())) {
                    if (!pet.getIdade().contains(informacao[3])) {
                        passou = false;
                    }
                } else {
                    try {
                        Double idade = Double.parseDouble(pet.getIdade());
                        Double idade1 = Double.parseDouble(informacao[3]);
                        if (!(idade == idade1)) {
                            passou = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            if (informacao[4] != null && !pet.getPeso().contains(informacao[4])) {
                passou = false;
            }
            if (informacao[6] != null && !pet.getEndereco().getRua().toUpperCase().contains(informacao[6].toUpperCase())
                    && !pet.getEndereco().getNumeroCasa().contains(informacao[6])
                    && !pet.getEndereco().getCidade().toUpperCase().contains(informacao[6].toUpperCase())) {
                passou = false;
            }

            if (informacao[5] != null && !pet.getRaca().toUpperCase().contains(informacao[5].toUpperCase())) {
                passou = false;
            }
            if (passou) {
                listaPet.add(pet);
            }

        }
        return listaPet;
    }
}
