package com.example.demo.controller;

import com.example.demo.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);

var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        DadosListagemMedico medicoCriado = new DadosListagemMedico(medico);
return ResponseEntity.created(uri).body(medicoCriado);
    }

    @GetMapping
    public ResponseEntity<Page<Medico>> listarMedicos(){
        Pageable pageable = PageRequest.of(0, 10);
        var page = medicoRepository.findAll(pageable);
        return ResponseEntity.ok(page);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        DadosListagemMedico medicoDetalhado = new DadosListagemMedico(medico);
        return ResponseEntity.ok(medicoDetalhado);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        DadosListagemMedico medicoAtualizado = new DadosListagemMedico(medico);
        return ResponseEntity.ok(medicoAtualizado);

    }

    @PutMapping("/desativar")
    @Transactional
    public ResponseEntity desativar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.desativar(dados);
        DadosListagemMedico medicoDesativado = new DadosListagemMedico(medico);
        return ResponseEntity.ok(medicoDesativado);
    }

    @PutMapping("/ativar")
    @Transactional
    public ResponseEntity ativar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.ativar(dados);
        DadosListagemMedico medicoAtivado = new DadosListagemMedico(medico);
        return ResponseEntity.ok(medicoAtivado);
    }
}
