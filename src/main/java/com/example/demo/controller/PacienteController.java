package com.example.demo.controller;

import com.example.demo.paciente.DadosCadastroPaciente;
import com.example.demo.paciente.Paciente;
import com.example.demo.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


@Autowired
private PacienteRepository pacienteRepository;

@PostMapping
@Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados){
        Paciente paciente = new Paciente(dados);
        pacienteRepository.save(paciente);

    }
    @GetMapping
    public Page<Paciente> listarPaciente(){
        Pageable pageable = PageRequest.of(0, 10);
        return pacienteRepository.findAll(pageable);
    }
}
