package com.conexao.estrutura.config;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.conexao.estrutura.repository.neo4j",
repositoryImplementationPostfix = "Neo4j") // Adiciona sufixo)
public class Neo4jConfig {

    @Bean
    public PlatformTransactionManager transactionManager(Driver driver) {
        return new Neo4jTransactionManager(driver);
    }
}
