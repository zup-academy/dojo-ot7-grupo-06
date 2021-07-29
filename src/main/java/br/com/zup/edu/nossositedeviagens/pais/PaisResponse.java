package br.com.zup.edu.nossositedeviagens.pais;

public class PaisResponse {

    private Long id;
    private String nome;

    public PaisResponse(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }
}
