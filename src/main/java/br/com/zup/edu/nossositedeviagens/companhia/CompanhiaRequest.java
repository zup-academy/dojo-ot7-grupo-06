package br.com.zup.edu.nossositedeviagens.companhia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanhiaRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Long idPais;

    
}
