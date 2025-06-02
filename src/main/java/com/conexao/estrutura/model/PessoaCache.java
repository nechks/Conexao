package com.conexao.estrutura.model;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;
import lombok.*;

@RedisHash("PessoaModel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaCache {

    @Id
    private String id;  // Pode ser o mesmo id do banco PostgreSQL

    private String name;
    private String email;
    private String cpf;
    private String dataNascimento;

}
