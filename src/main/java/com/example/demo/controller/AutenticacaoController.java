package com.example.demo.controller;

import com.example.demo.domain.usuario.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth = authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
