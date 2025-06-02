package com.conexao.estrutura.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.conexao.estrutura.model.PessoaLog;

public interface PessoaLogRepository extends MongoRepository<PessoaLog, String> {}
