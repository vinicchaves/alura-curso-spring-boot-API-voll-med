package com.example.demo.domain.medico;

public record DadosListagemMedico(Long id,String nome, String email, String crm, Boolean status, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getStatus(), medico.getEspecialidade());
    }

}
