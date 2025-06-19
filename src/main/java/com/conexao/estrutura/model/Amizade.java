package com.conexao.estrutura.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.neo4j.core.schema.RelationshipId;

@RelationshipProperties
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Amizade {

    @RelationshipId
    private Long id;
    private String desde; // exemplo: data do início da amizade
    @TargetNode
    private PessoaRelacionamento amigo;
}

