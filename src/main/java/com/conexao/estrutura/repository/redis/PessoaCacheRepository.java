package com.conexao.estrutura.repository.redis;

import org.springframework.data.repository.CrudRepository;

import com.conexao.estrutura.model.PessoaCache;

public interface PessoaCacheRepository extends CrudRepository<PessoaCache, String> {}
