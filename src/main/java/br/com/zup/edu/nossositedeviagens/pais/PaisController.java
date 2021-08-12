package br.com.zup.edu.nossositedeviagens.pais;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1/paises")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<PaisResponse> criar(@RequestBody @Valid PaisRequest paisRequest) {

        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/v1/paises/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisResponse(pais));
    }
}
