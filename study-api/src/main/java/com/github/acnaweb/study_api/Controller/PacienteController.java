package com.github.acnaweb.study_api.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_api.Service.PacienteService;
import com.github.acnaweb.study_api.dto.PacienteCreate;
import com.github.acnaweb.study_api.dto.PacienteResponse;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

     @Autowired
     PacienteService ps;
     
    @PostMapping
    public  ResponseEntity<PacienteResponse> create(@RequestBody PacienteCreate pc){
        System.out.println(pc);
        PacienteResponse pr = new PacienteResponse(ps.create(pc));
        return ResponseEntity.status(201).body(pr);
    }
    @GetMapping
    public ResponseEntity<List<PacienteResponse>> findAll(){
        List<PacienteResponse> l = ps.findAll().stream()
                                    .map(paciente ->{
                                        PacienteResponse pr = new PacienteResponse(paciente);
                                        return pr;
                                    })
                                    .collect(Collectors.toList());
        return ResponseEntity.ok(l);
    }
    @GetMapping("{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable long id){
        return ps.findById(id).map(paciente-> {
            PacienteResponse pr = new PacienteResponse(paciente);
            return ResponseEntity.ok(pr);
        })
        .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ps.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("({id})")
    public ResponseEntity<PacienteResponse> update(@PathVariable Long id, @RequestBody PacienteCreate pc) {
        return ps.update(id, pc)
                .map(paciente -> {
                    PacienteResponse response = new PacienteResponse(paciente);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
