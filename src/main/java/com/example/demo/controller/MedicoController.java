package com.example.demo.controller;

import com.example.demo.medico.DadosCadastroMedico;
import com.example.demo.medico.DadosListagemMedico;
import com.example.demo.medico.Medico;
import com.example.demo.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);

    }

    @GetMapping
    public Page<Medico> listarMedicos(){
        Pageable pageable = PageRequest.of(0, 10);
        return medicoRepository.findAll(pageable);

    }

    @PutMapping
    public void atualizar(){

    }
}
