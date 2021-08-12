package br.com.zup.edu.nossositedeviagens.companhia;

import br.com.zup.edu.nossositedeviagens.compartilhado.validators.ExistsById;
import br.com.zup.edu.nossositedeviagens.compartilhado.validators.UniqueValue;
import br.com.zup.edu.nossositedeviagens.pais.Pais;
import br.com.zup.edu.nossositedeviagens.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanhiaRequest {

    @NotBlank
    @UniqueValue(domainClass = Companhia.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistsById(fieldName = "id", domainClass = Pais.class)
    private Long idPais;


    public Companhia toModel(PaisRepository paisRepository) {
        Pais pais = paisRepository.findById(idPais).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new Companhia(nome, pais);
    }
}
