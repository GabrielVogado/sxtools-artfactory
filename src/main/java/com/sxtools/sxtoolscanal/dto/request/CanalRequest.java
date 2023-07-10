package com.sxtools.sxtoolscanal.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CanalRequest {


    private String nomeCanal;

    private Boolean canalAtivo;

    private String descricaoCanal;

    private LocalDateTime dhInclusao;

    private String cdUsuarioInclusao;

    private LocalDateTime dhUltimaAtualizacao;

    private String cdUltimaAtualizacao;
}
