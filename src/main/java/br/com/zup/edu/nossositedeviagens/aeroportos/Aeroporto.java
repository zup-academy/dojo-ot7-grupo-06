package br.com.zup.edu.nossositedeviagens.aeroportos;

import br.com.zup.edu.nossositedeviagens.pais.Pais;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Aeroporto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Aeroporto(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }
}
