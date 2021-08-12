package br.com.zup.edu.nossositedeviagens.aeroportos;

import br.com.zup.edu.nossositedeviagens.compartilhado.validators.ExistsById;
import br.com.zup.edu.nossositedeviagens.compartilhado.validators.UniqueValue;
import br.com.zup.edu.nossositedeviagens.pais.Pais;
import br.com.zup.edu.nossositedeviagens.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportosRequest {

    @NotBlank @UniqueValue(domainClass = Aeroporto.class, fieldName = "id")
    private String nome;

    @NotNull @ExistsById(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Aeroporto toModel(PaisRepository paisRepository) {
        Pais pais = paisRepository.findById(this.idPais).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new Aeroporto(this.nome, pais);
    }
}
