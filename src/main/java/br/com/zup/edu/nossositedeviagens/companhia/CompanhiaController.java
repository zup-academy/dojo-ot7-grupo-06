package br.com.zup.edu.nossositedeviagens.companhia;

import br.com.zup.edu.nossositedeviagens.pais.PaisRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/companhia")
public class CompanhiaController {

    public ResponseEntity<?> criar(@RequestBody @Valid CompanhiaRequest companhiaRequest, UriComponentsBuilder uriBuilder){



    }
}
