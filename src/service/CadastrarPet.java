package service;

import java.util.Scanner;

import domain.Endereco;
import domain.Pet;
import domain.Sexo;
import domain.TipoPet;
import excecoes.TipoInvalidoException;

public class CadastrarPet {
    public void cadastrar() {
        Scanner input = new Scanner(System.in);
        String[] repostasForm = LerForm.lerForm();
        Pet pet1 = new Pet();

        // nome
        pet1.setNome(repostasForm[0]);

        // tipo cachorro/gato
        if (repostasForm[1].equalsIgnoreCase("cachorro")) {
            pet1.setTipoPet(TipoPet.CACHORRO);
        } else if (repostasForm[1].equalsIgnoreCase("gato")) {
            pet1.setTipoPet(TipoPet.GATO);
        } else {
            throw new TipoInvalidoException("login invalido");
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
        System.out.println("Qual sua cidade? ");
        repostasForm[3] = input.nextLine();
        Endereco enderecoPet1 = new Endereco();
        enderecoPet1.setCidade(repostasForm[3]);

        System.out.println("Qual o numero da casa?");
        try {
                String numero = input.nextLine();
        enderecoPet1.setNumeroCasa(numero);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("numero invalido");
        }

        System.out.println("qual a rua? ");
        enderecoPet1.setRua(input.nextLine());

        pet1.setEndereco(enderecoPet1);
    }
}