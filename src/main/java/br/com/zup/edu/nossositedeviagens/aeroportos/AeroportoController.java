package br.com.zup.edu.nossositedeviagens.aeroportos;

import br.com.zup.edu.nossositedeviagens.companhia.Companhia;
import br.com.zup.edu.nossositedeviagens.companhia.CompanhiaRequest;
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
@RequestMapping("/v1/aeroportos")
public class AeroportoController {

    private final AeroportoRepository aeroportoRepository;
    private final PaisRepository paisRepository;

    public AeroportoController(AeroportoRepository aeroportoRepository, PaisRepository paisRepository) {
        this.aeroportoRepository = aeroportoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid AeroportosRequest aeroportosRequest){
        Aeroporto aeroporto = aeroportosRequest.toModel(paisRepository);

        aeroportoRepository.save(aeroporto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aeroporto.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
