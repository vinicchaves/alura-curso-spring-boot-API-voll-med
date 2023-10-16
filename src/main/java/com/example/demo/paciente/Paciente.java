package com.example.demo.paciente;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="Paciente")
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;


    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();

    }
}
