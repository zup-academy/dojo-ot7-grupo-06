package br.com.zup.edu.nossositedeviagens.companhia;

import br.com.zup.edu.nossositedeviagens.pais.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/companhia")
public class CompanhiaController {


    private final PaisRepository paisRepository;

    public CompanhiaController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public ResponseEntity<?> criar(@RequestBody @Valid CompanhiaRequest companhiaRequest, UriComponentsBuilder uriBuilder){

        Companhia companhia = companhiaRequest.toModel(paisRepository);

    }
}
