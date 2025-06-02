package com.conexao.estrutura.repository.postgres;
import org.springframework.data.jpa.repository.JpaRepository;

import com.conexao.estrutura.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}