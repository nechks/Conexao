package com.conexao.estrutura.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.conexao.estrutura.services.PessoaRelacionamentoServices;
import com.conexao.estrutura.services.PessoaService;
import com.conexao.estrutura.services.RedisCrud;

import lombok.*;

@Component
@RequiredArgsConstructor
public class RegistroPessoas implements CommandLineRunner {

 private final PessoaService pessoaService;
 private final RedisCrud redisCrud;
 private final PessoaRelacionamentoServices pessoaRelacionamentoServices;

 @Override
 public void run(String... args) {

  pessoaService.criar();
  redisCrud.buscarPorCpf("123");
  System.out.println("salvo com sucesso");

  pessoaRelacionamentoServices.criarAmizade(1l,2l);
  
 
  }
  
}
