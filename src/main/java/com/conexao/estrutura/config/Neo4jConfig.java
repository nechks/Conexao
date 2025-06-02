package com.conexao.estrutura.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(
    basePackages = "com.conexao.estrutura.repository.neo4j"
)
public class Neo4jConfig {}
