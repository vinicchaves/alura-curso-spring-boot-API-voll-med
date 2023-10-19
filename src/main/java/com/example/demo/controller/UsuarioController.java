package com.example.demo.controller;

import com.example.demo.domain.paciente.DadosCadastroPaciente;
import com.example.demo.domain.paciente.Paciente;
import com.example.demo.domain.usuario.Usuario;
import com.example.demo.domain.usuario.UsuarioDTO;
import com.example.demo.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

@Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid UsuarioDTO dados){
        Usuario usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();

    }
}
