package com.conexao.estrutura.services;

import com.conexao.estrutura.model.*;
import com.conexao.estrutura.repository.neo4j.PessoaRelacionamentoRepository;
import com.conexao.estrutura.repository.postgres.PessoaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;

@Service
@RequiredArgsConstructor

public class PessoaRelacionamentoServices {

    private final PessoaRelacionamentoRepository repository;
    private final PessoaRepository pessoaRepository;

    public void criarAmizade(Long idPessoa1, Long idPessoa2) {
        // 1. Buscar pessoas do PostgreSQL
        PessoaModel pessoa1 = pessoaRepository.findById(idPessoa1).orElseThrow();
        PessoaModel pessoa2 = pessoaRepository.findById(idPessoa2).orElseThrow();
    
        // 2. Criar os nós equivalentes no Neo4j
        PessoaRelacionamento rel1 = PessoaRelacionamento.builder()
                .nome(pessoa1.getName())
                .dataNascimento(pessoa1.getDataNascimento())
                .amigos(new HashSet<>()) // inicializa lista
                .build();
    
        PessoaRelacionamento rel2 = PessoaRelacionamento.builder()
                .nome(pessoa2.getName())
                .dataNascimento(pessoa2.getDataNascimento())
                .amigos(new HashSet<>())
                .build();
    
        // 3. Salvar os nós no Neo4j para receberem IDs
        rel1 = repository.save(rel1);
        rel2 = repository.save(rel2);
    
        // 4. Criar a amizade entre eles
        Amizade amizade1 = Amizade.builder()
                .amigo(rel2)
                .desde(LocalDate.now().toString())
                .build();
    
        Amizade amizade2 = Amizade.builder()
                .amigo(rel1)
                .desde(LocalDate.now().toString())
                .build();
    
        // 5. Associar amizades
        rel1.getAmigos().add(amizade1);
        rel2.getAmigos().add(amizade2);
    
        // 6. Salvar novamente com os relacionamentos
        repository.save(rel1);
        repository.save(rel2);
    
        System.out.println("Amizade criada entre " + rel1.getNome() + " e " + rel2.getNome());
    }
    
    
}
