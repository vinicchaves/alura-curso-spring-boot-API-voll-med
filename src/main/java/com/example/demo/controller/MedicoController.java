package com.example.demo.controller;

import com.example.demo.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        medicoRepository.deleteById(id);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

    @PutMapping("/desativar")
    @Transactional
    public void desativar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.desativar(dados);
    }

    @PutMapping("/ativar")
    @Transactional
    public void ativar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.ativar(dados);
    }
}
