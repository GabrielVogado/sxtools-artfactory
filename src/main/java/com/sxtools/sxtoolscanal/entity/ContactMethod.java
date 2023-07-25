package com.sxtools.sxtoolscanal.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "METHOD_CONTACT")
public class ContactMethod implements Serializable {

    @Id
    @Column(name = "SK_METODO_CONTATO")
    private Integer skMethodContact;

    @Column(name = "NOME_METODO_CONTATO")
    private String nmMethodContact;

    @Column(name = "DS_METODO_CONTATO")
    private String dsMethodContact;

    @Column(name = "IN_METODO_CONTATO")
    private Boolean inMethodContact;

    @Column(name = "DH_INCLUSAO")
    private LocalDateTime dhInclusao;

    @Column(name = "CD_USUARIO_INCLUSAO")
    private String cdUsuarioInclusao;

    @Column(name = "DH_ULTIMA_ATUALIZACAO")
    private LocalDateTime dhUltimaAtualizacao;

    @Column(name = "CD_ULTIMA_ATUALIZACAO")
    private String cdUltimaAtualizacao;

}
