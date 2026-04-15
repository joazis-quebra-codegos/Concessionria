package org.example.concessionariajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
@Table(name = "tbcarro")
@Entity
@Getter
@Setter
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    private Double preco;

    @NotBlank(message = "Marca é obrigatória")
    private String marca;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Ano é obrigatório")
    private Integer ano;

    @NotNull(message = "Disponibilidade é obrigatória")
    private Boolean disponivel;

    public Carro(){
    }
}
