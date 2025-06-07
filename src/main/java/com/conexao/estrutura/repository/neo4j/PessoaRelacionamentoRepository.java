package com.conexao.estrutura.repository.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.conexao.estrutura.model.PessoaModel;
import com.conexao.estrutura.model.PessoaRelacionamento;

public interface PessoaRelacionamentoRepository extends Neo4jRepository<PessoaModel, Long> {}

