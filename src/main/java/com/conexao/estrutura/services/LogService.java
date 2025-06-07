package com.conexao.estrutura.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.conexao.estrutura.model.PessoaLog;
import com.conexao.estrutura.repository.mongo.PessoaLogRepository;
import lombok.RequiredArgsConstructor;

@Component
@Service
@RequiredArgsConstructor
public class LogService {

    private final PessoaLogRepository pessoaLogRepository;

    public void salvarLog(String mensagem, String nivel) {
        PessoaLog log = new PessoaLog(null, mensagem, nivel);
        pessoaLogRepository.save(log);

     System.out.println("Salvamento no mongo OSSECUS" + log);   
    }
}
