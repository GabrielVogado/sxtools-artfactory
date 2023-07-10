package com.sxtools.sxtoolscanal.dto;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.entity.Canal;

import java.time.LocalDateTime;

public class CanalTypeModelDto {

    public static CanalResponse getResponseCanal(){
    return CanalResponse.builder()
            .canalAtivo(Boolean.TRUE)
            .nomeCanal("Canal")
            .descricaoCanal("Teste Canal")
            .cdUltimaAtualizacao("1")
            .cdUsuarioInclusao("1")
            .dhInclusao(LocalDateTime.now())
            .dhUltimaAtualizacao(LocalDateTime.now().plusDays(1))
            .build();
    }

    public static CanalRequest getRequestCanal(){
        return CanalRequest.builder()
                .canalAtivo(Boolean.TRUE)
                .nomeCanal("Canal")
                .descricaoCanal("Teste Canal")
                .cdUltimaAtualizacao("1")
                .cdUsuarioInclusao("1")
                .dhInclusao(LocalDateTime.now())
                .dhUltimaAtualizacao(LocalDateTime.now().plusDays(1))
                .build();
    }

    public static Canal getEntityCanal(){
        return Canal.builder()
                .canalAtivo(Boolean.TRUE)
                .nomeCanal("Canal")
                .descricaoCanal("Teste Canal")
                .cdUltimaAtualizacao("1")
                .cdUsuarioInclusao("1")
                .dhInclusao(LocalDateTime.now())
                .dhUltimaAtualizacao(LocalDateTime.now().plusDays(1))
                .build();
    }
}
