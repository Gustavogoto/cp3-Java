package com.github.acnaweb.study_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PacienteCreate {

    private String nome;
    private String bairro;
    private String email;
    private String telefone_completo;
    

}
