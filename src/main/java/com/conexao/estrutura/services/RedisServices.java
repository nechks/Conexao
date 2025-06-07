package com.conexao.estrutura.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.conexao.estrutura.model.PessoaModel;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServices {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Método genérico para salvar com expiração
    public void salvar(String chave, Object valor, long ttl, TimeUnit unidadeTempo) {
        redisTemplate.opsForValue().set(chave, valor, ttl, unidadeTempo);
        System.out.println("Salvou no Redis: chave = " + chave + ", valor = " + valor);
    }

    // Método genérico para buscar
    public <T> T buscar(String chave, Class<T> tipo) {
        Object valor = redisTemplate.opsForValue().get(chave);
        System.out.println("Buscou no Redis: chave = " + chave + ", valor = " + valor);
        return tipo.cast(valor); // Converte para o tipo específico (ex: Pessoa)
    }

    // Método genérico para deletar
    public void deletar(String chave) {
        redisTemplate.delete(chave);
    }

    // Método especializado para Pessoa (opcional, mas útil para encapsular a chave)
    public PessoaModel buscarPessoaPorCpf(String cpf) {
        String chave = "pessoa:cpf:" + cpf;
        return buscar(chave, PessoaModel.class);
    }

    public void salvarPessoa(PessoaModel pessoa, long ttl, TimeUnit unidadeTempo) {
        String chave = "pessoa:cpf:" + pessoa.getCpf();
        salvar(chave, pessoa, ttl, unidadeTempo);
    }

    public void deletarPessoa(String cpf) {
        String chave = "pessoa:cpf:" + cpf;
        deletar(chave);
    }
}
