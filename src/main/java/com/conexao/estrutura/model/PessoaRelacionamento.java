package com.conexao.estrutura.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Node("PessoaModel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaRelacionamento {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private Integer idade;

    @Relationship(type = "AMIGO_DE", direction = Relationship.Direction.OUTGOING)
    private Set<PessoaRelacionamento> amigos;
}
