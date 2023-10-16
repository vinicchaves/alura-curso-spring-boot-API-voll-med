package com.example.demo.medico;

import com.example.demo.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,

        Boolean status,
        DadosEndereco endereco) {
}
