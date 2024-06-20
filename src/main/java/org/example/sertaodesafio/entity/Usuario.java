package org.example.sertaodesafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    private String senha;

    private Boolean ativo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pe_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Perfil perfil;
}