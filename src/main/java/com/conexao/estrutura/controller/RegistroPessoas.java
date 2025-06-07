package com.conexao.estrutura.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.conexao.estrutura.model.Amizade;
import com.conexao.estrutura.model.PessoaRelacionamento;
import com.conexao.estrutura.repository.neo4j.PessoaRelacionamentoRepository;
import com.conexao.estrutura.services.PessoaService;
import com.conexao.estrutura.services.RedisCrud;

import lombok.*;

@Component
@RequiredArgsConstructor
public class RegistroPessoas implements CommandLineRunner {

 private final PessoaService pessoaService;
 private final PessoaRelacionamentoRepository neo4j;
 private final RedisCrud redisCrud;

 @Override
 public void run(String... args) {

  pessoaService.criar();
  redisCrud.buscarPorCpf("123");
  System.out.println("salvo com sucesso");

  PessoaRelacionamento pessoa1 = neo4j.findById(1L).get();
  PessoaRelacionamento pessoa2 = neo4j.findById(2L).get();

  Amizade amizade = new Amizade();
  amizade.setDesde("2023");
  amizade.setAmigo(pessoa2);

  pessoa1.getAmigos().add(amizade);
  neo4j.save(pessoa1);

 }
}
