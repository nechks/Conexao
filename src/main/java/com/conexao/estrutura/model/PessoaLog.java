package com.conexao.estrutura.model;

//import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "registro")
public class PessoaLog {
 
 @Id
 private Long id;
 
 private String mensagem;
 private String nivel;
 //private LocalDate dataHora;
}
