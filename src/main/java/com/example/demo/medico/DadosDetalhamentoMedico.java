package com.example.demo.medico;

import com.example.demo.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {
}
