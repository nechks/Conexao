package com.conexao.estrutura.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.conexao.estrutura.services.PessoaService;

import lombok.*;

@Component
@RequiredArgsConstructor
public class RegistroPessoas implements CommandLineRunner {

 
 private final PessoaService pessoaService;

 @Override
 public void run(String... args) {
  
  pessoaService.criar();
  pessoaService.buscarPorId(1L);

  System.out.println("salvo com sucesso");
 

 }
}
