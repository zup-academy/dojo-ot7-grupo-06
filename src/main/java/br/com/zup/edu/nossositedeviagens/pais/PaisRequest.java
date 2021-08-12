package br.com.zup.edu.nossositedeviagens.pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    private String nome;

    public Pais toModel() {

        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
