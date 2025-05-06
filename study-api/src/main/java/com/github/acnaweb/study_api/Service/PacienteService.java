package com.github.acnaweb.study_api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_api.dto.PacienteCreate;
import com.github.acnaweb.study_api.model.Paciente;
import com.github.acnaweb.study_api.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pr ;
    
    public Paciente create(PacienteCreate p){
        Paciente p1 = new Paciente();
        p1.setBairro(p.getBairro());
        p1.setEmail(p.getEmail());
        p1.setTelefone_completo(p.getTelefone_completo());
        p1.setNome(p.getNome());
        System.out.println(p1);
        return pr.save(p1);
    }
    public List<Paciente> findAll(){
        return pr.findAll();
    }
    public Optional<Paciente> findById(Long id) {
        return pr.findById(id);
    }
    public Optional<Paciente> update(long id, PacienteCreate p){
        if (pr.existsById(id)) {
            return pr.findById(id)
                    .map(p1 -> {
                        p1.setBairro(p.getBairro());
                        p1.setEmail(p.getEmail());
                        p1.setTelefone_completo(p.getTelefone_completo());
                        p1.setNome(p.getNome());
                        return pr.save(p1);
                    });
        }
        return null;
    }
    public boolean delete(long id){
        if (pr.existsById(id)){
            pr.deleteById(id);
        }
        return false;
    }

    }

