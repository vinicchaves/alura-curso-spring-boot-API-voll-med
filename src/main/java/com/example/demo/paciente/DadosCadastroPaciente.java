package com.example.demo.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        @Email
        String email
) {
}
