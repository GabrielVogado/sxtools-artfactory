package com.sxtools.sxtoolscanal.dto;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Canal;

import java.time.LocalDateTime;

public class CanalTypeModelDto {

    public static CanalResponse getResponseCanal(){
    return CanalResponse.builder()
            .active(Boolean.TRUE)
            .name("Canal")
            .description("Teste Canal")
            .updateDate(String.valueOf(LocalDateTime.now().plusDays(1)))
            .createDate(String.valueOf(LocalDateTime.now()))
            .tenantId(1)
            .groupId(1)
            .createUser("Canal")
            .updateUser("Canal Teste")
            .build();
    }

    public static CanalRequest getRequestCanal(){
        return CanalRequest.builder()
                .active(Boolean.TRUE)
                .name("Canal")
                .description("Teste Canal")
                .groupId(1)
                .tenantId(1)
                .build();
    }

    public static Canal getEntityCanal(){
        return Canal.builder()
                .canalAtivo(Boolean.TRUE)
                .nomeCanal("Canal")
                .descricaoCanal("Teste Canal")
                .cdUltimaAtualizacao("Canal Teste")
                .cdUsuarioInclusao("Canal")
                .dhInclusao(LocalDateTime.now())
                .dhUltimaAtualizacao(LocalDateTime.now().plusDays(1))
                .cdTenant(1)
                .skGrupo(1)
                .build();
    }

    public static DtoResponse getResponseCanalDto() {
        return DtoResponse.builder()
                .id(1)
                .createDate(String.valueOf(LocalDateTime.now())).build();
    }
}
