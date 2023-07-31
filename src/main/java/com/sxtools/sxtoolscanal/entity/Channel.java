package com.sxtools.sxtoolscanal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CANAL")
public class Channel implements Serializable {

    @Id
    @Column(name = "SK_CANAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NM_CANAL")
    private String nomeCanal;

    @Column(name = "IN_CANAL")
    private Boolean canalAtivo;

    @Column(name = "DS_CANAL")
    private String descricaoCanal;

    @Column(name = "DH_INCLUSAO")
    private LocalDateTime dhInclusao;

    @Column(name = "CD_USUARIO_INCLUSAO")
    private String cdUsuarioInclusao;

    @Column(name = "DH_ULTIMA_ATUALIZACAO")
    private LocalDateTime dhUltimaAtualizacao;

    @Column(name = "CD_ULTIMA_ATUALIZACAO")
    private String cdUltimaAtualizacao;

    @Column(name = "SK_GRUPO")
    private Integer skGrupo;

    @Column(name = "CD_TENANT")
    private Integer cdTenant;

    @PrePersist
    public void prePersist() {
        dhInclusao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dhUltimaAtualizacao = LocalDateTime.now();
    }

}
