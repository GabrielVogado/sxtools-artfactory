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
@Table(name = "SEVERITY")
public class Severity implements Serializable {

    @Id
    @Column(name = "SK_SEVERITY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NM_SEVERIDADE")
    private String nomeSeveridade;

    @Column(name = "DS_SEVERIDADE")
    private String dsSeveridade;

    @Column(name = "IN_SEVERIDADE")
    private Boolean inSeveridade;

    @Column(name = "CD_TENANT")
    private String cdTenant;

    @Column(name = "HR_SLA_SEVERIDADE")
    private Integer hrSlaSeveridade;

    @Column(name = "SK_GRUPO")
    private Integer skGrupo;

    @Column(name = "DH_INCLUSAO")
    private LocalDateTime dhInclusao;

    @Column(name = "CD_USUARIO_INCLUSAO")
    private String cdUsuarioInclusao;

    @Column(name = "DH_ULTIMA_ATUALIZACAO")
    private LocalDateTime dhUltimaAtualizacao;

    @Column(name = "CD_ULTIMA_ATUALIZACAO")
    private String cdUltimaAtualizacao;

}
