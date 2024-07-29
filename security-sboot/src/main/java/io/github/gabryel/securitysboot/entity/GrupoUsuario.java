package io.github.gabryel.securitysboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GRUPOS_USUARIOS")
public class GrupoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "GRUPO_ID")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

}
