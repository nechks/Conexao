package com.conexao.estrutura.services;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import com.conexao.estrutura.model.PessoaModel;
import com.conexao.estrutura.repository.postgres.PessoaRepository;
import lombok.*;
@Service
@RequiredArgsConstructor
public class RedisCrud {
 
 private final RedisServices redisService;
 private final PessoaRepository pessoaRepository; // Injetado para operações de cache

 // ---- Métodos limpos e focados na regra de negócio ----
 public PessoaModel buscarPorCpf(String cpf) {
  // 1. Tenta buscar do Redis (via RedisService)
  PessoaModel pessoaModel = redisService.buscarPessoaPorCpf(cpf);
  if (pessoaModel != null) {
   return pessoaModel;
  }


  // 2. Busca no banco de dados se não achar no Redis
  pessoaModel = pessoaRepository.findByCpf(cpf)
    .orElseThrow(() -> new RuntimeException("PessoaModel não encontrada!"));
  // 3. Salva no Redis (via RedisService)
  redisService.salvarPessoa(pessoaModel, 1, TimeUnit.HOURS);
  return pessoaModel;
 }

 public PessoaModel salvarPessoaModel(PessoaModel pessoaModel) {
  PessoaModel PessoaModelSalva = pessoaRepository.save(pessoaModel);
  redisService.salvarPessoa(PessoaModelSalva, 1, TimeUnit.HOURS); // Atualiza cache
  return PessoaModelSalva;
 }

 public void deletarPorCpf(String cpf) {
  redisService.deletarPessoa(cpf); // Remove do cache
 }
}
