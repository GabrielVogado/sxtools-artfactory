package com.sxtools.sxtoolscanal.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CanalResponse {


    private String nomeCanal;

    private Boolean canalAtivo;

    private String descricaoCanal;

    private LocalDateTime dhInclusao;

    private String cdUsuarioInclusao;

    private LocalDateTime dhUltimaAtualizacao;

    private String cdUltimaAtualizacao;
}
