package br.com.zup.edu.nossositedeviagens.companhia;

import br.com.zup.edu.nossositedeviagens.pais.Pais;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String nome;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @NotNull
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Companhia() {
    }

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }
}
