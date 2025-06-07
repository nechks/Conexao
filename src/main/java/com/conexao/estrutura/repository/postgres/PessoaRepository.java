package com.conexao.estrutura.repository.postgres;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conexao.estrutura.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
 Optional<PessoaModel> findByCpf(String cpf);
}