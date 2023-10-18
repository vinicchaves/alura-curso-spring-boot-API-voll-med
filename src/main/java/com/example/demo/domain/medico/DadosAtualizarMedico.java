package com.example.demo.domain.medico;

import com.example.demo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,

        Boolean status,
        DadosEndereco endereco) {
}
