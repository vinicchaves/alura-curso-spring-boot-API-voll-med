package com.example.demo.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor
@Entity (name="Usuario")
@Table (name="usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
}
