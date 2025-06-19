package com.conexao.estrutura.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.conexao.estrutura.repository.postgres",
    repositoryImplementationPostfix = "Jpa" // Adiciona sufixo
)
public class JpaConfig {}
