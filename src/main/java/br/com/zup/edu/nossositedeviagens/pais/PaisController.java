package br.com.zup.edu.nossositedeviagens.pais;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid Pais pais){


    }

}
