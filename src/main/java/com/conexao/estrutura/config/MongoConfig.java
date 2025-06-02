package com.conexao.estrutura.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.conexao.estrutura.repository.mongo")
public class MongoConfig {}