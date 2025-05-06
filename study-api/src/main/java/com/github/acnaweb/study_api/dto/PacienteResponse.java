package com.github.acnaweb.study_api.dto;

import com.github.acnaweb.study_api.model.Paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PacienteResponse {

    private Long id;
    private String nome;
    private String bairro;
    private String email;
    private String telefone_completo;
        public PacienteResponse(Paciente paciente){
        this.nome = paciente.getNome();
        this.bairro = paciente.getBairro();
        this.email = paciente.getEmail();
        this.telefone_completo = paciente.getTelefone_completo();
    }
}
