package service;

import java.util.Scanner;

import domain.Endereco;
import domain.NaoInformado;
import domain.Pet;
import domain.Sexo;
import domain.TipoPet;
import excecoes.TipoInvalidoException;

public class CadastrarPet {
    public void cadastrar() {
        Scanner input = new Scanner(System.in,"UTF-8");
        String[] repostasForm = LerForm.lerForm();
        Pet pet1 = new Pet();

        // nome
        String regexNome = "^[a-zA-ZÀ-ÿ\\s]+$";
        boolean nomeValidado = repostasForm[0].matches(regexNome);
        if (!nomeValidado) {
            try {
                throw new TipoInvalidoException("nome invalido");
            } catch (TipoInvalidoException e) {
                e.printStackTrace();
                do {
                    System.out.println("digite um nome valido");
                    repostasForm[0] = input.nextLine();
                    nomeValidado = repostasForm[0].matches(regexNome);
                } while (!nomeValidado);
                pet1.setNome(repostasForm[0]);
            }
        } else {
            pet1.setNome(repostasForm[0]);
        }

        // tipo cachorro/gato

        if (repostasForm[1].equalsIgnoreCase("cachorro")) {
            pet1.setTipoPet(TipoPet.CACHORRO);
        } else if (repostasForm[1].equalsIgnoreCase("gato")) {
            pet1.setTipoPet(TipoPet.GATO);
        } else {
            throw new TipoInvalidoException("tipo invalido");
        }

        // tipo do sexo
        if (repostasForm[2].equalsIgnoreCase("masculino")) {
            pet1.setSexo(Sexo.MASCULINO);
        } else if (repostasForm[2].equalsIgnoreCase("feminino")) {
            pet1.setSexo(Sexo.FEMININO);
        } else {
            throw new TipoInvalidoException("sexo invalido");
        }

        // endreço do pet
        // cidade
        System.out.println("Qual sua cidade? ");
        repostasForm[3] = input.nextLine();
        Endereco enderecoPet1 = new Endereco();
        enderecoPet1.setCidade(repostasForm[3]);
        // numero
        System.out.println("Qual o numero da casa?");

        String numero = input.nextLine();
        enderecoPet1.setNumeroCasa(numero);

        // rua
        System.out.println("qual a rua? ");
        enderecoPet1.setRua(input.nextLine());

        pet1.setEndereco(enderecoPet1);
        // idade do pet
        try {
            String idade = repostasForm[4];
            String idadeFinal;

            if (idade.isEmpty()) {
                idadeFinal = NaoInformado.NAO_INFORMADO;
            } else {
                double idadePet = Double.parseDouble(idade);
                if (idadePet > 20) {
                    throw new TipoInvalidoException("idade invalida");
                }
                if (idadePet < 1) {
                    idadePet = idadePet / 12;
                }
                idadeFinal = String.valueOf(idadePet);
            }

            pet1.setIdade(idadeFinal);
        } catch (TipoInvalidoException e) {
            e.printStackTrace();
        }

        // peso do pet
        String peso = repostasForm[5];
        String pesoFinal = "";
        try {
            if (peso.isEmpty()) {
                pesoFinal = NaoInformado.NAO_INFORMADO;
            } else {
                double pesoPet = Double.parseDouble(peso);
                if (pesoPet > 60) {
                    throw new TipoInvalidoException(" peso invalido");
                }
                if (pesoPet < 0.5) {
                    throw new TipoInvalidoException(" peso invalido");
                }
                pesoFinal = String.valueOf(pesoPet);
            }
            pet1.setPeso(pesoFinal);
        } catch (TipoInvalidoException e) {
            e.printStackTrace();
        }
        // raça do pet
        String regexRaca = "^[a-zA-ZÀ-ÿ\\s]+$";
        boolean racaValidada = repostasForm[6].matches(regexRaca);
        if (repostasForm[6].isEmpty()) {
            pet1.setRaca(NaoInformado.NAO_INFORMADO);
        }else
        if (!racaValidada) {
            try {
                throw new TipoInvalidoException("raça invalida");
            } catch (TipoInvalidoException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                do {
                    System.out.println("digite uma raça valida");
                    repostasForm[6] = input.nextLine();
                    racaValidada = repostasForm[6].matches(regexRaca);
                } while (!racaValidada);
                pet1.setRaca(repostasForm[6]);
            }
        }else{
             pet1.setRaca(repostasForm[6]);
        }
        // salvamento do pet
        SalvarPet.salvarPet(pet1);
        
    }
}