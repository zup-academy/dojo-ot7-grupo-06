package br.com.zup.edu.nossositedeviagens.pais;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String nome;

    @Deprecated
    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public Pais(String nome) {
        this.nome = nome;
    }
}
