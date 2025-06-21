package Classes;

public record Endereco(String logradouro, String bairro, String localidade, String uf, String cep) {

    @Override
    public String toString() {
        return "Endereço: " + logradouro + ", Bairro: " + bairro + ", Localidade: " + localidade + ", UF: " + uf + ", CEP: " + cep;
    }
}
