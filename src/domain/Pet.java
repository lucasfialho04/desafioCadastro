package domain;

public class Pet {
    private String nome;
    private String peso;
    private String raca;
    private String idade;
    private  Endereco endereco;
    private TipoPet tipoPet;
    private Sexo sexo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public TipoPet getTipoPet() {
        return tipoPet;
    }
    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    

    


}
