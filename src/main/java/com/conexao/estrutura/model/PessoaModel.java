package com.conexao.estrutura.model;

import org.springframework.data.neo4j.core.schema.Node;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "registro")
@Node("PessoaModel")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    @Column(unique = true)
    private String cpf;
    private String dataNascimento;

    @Version
    private Long version;
}