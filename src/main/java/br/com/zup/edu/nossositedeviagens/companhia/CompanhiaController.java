package br.com.zup.edu.nossositedeviagens.companhia;

import br.com.zup.edu.nossositedeviagens.pais.PaisRepository;
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
@RequestMapping("/v1/companhia")
public class CompanhiaController {

    private final PaisRepository paisRepository;

    private CompanhiaRepository companhiaRepository;

    public CompanhiaController(PaisRepository paisRepository, CompanhiaRepository companhiaRepository) {
        this.paisRepository = paisRepository;
        this.companhiaRepository = companhiaRepository;
    }

    public CompanhiaController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid CompanhiaRequest companhiaRequest, UriComponentsBuilder uriBuilder){
        Companhia companhia = companhiaRequest.toModel(paisRepository);

        companhiaRepository.save(companhia);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
