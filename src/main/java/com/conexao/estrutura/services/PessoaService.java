package com.conexao.estrutura.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.conexao.estrutura.model.PessoaModel;
import com.conexao.estrutura.repository.postgres.PessoaRepository;

import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {


    private final PessoaRepository pessoaRepository;
    private final LogService logService;

    public void criar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        PessoaModel pessoa = PessoaModel.builder()
            .name(nome)
            .email(email)
            .cpf(cpf)
            .dataNascimento(dataNascimento)
            .build();

        pessoaRepository.save(pessoa);
        logService.salvarLog("Pessoa salva com ID: " + pessoa.getId(), "INFO");
        System.out.println("Pessoa salva com sucesso: " + pessoa);
        scanner.close();
    }

   @Cacheable(value = "pessoaCache", key = "#id")
   public PessoaModel buscarPorId(Long id) {
    System.out.println("Buscando no banco o id " + id);
    return pessoaRepository.findById(id).orElse(null);
    }

    // Read (listar todos)
    public List<PessoaModel> listarTodos() {
        return pessoaRepository.findAll();
    }

    // Update
    public PessoaModel atualizar(Long id, PessoaModel dadosAtualizados) {
        PessoaModel pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        
        pessoa.setName(dadosAtualizados.getName());
        pessoa.setEmail(dadosAtualizados.getEmail());
        pessoa.setCpf(dadosAtualizados.getCpf());
        pessoa.setDataNascimento(dadosAtualizados.getDataNascimento());
        
        return pessoaRepository.save(pessoa);
    }

    // Delete
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}