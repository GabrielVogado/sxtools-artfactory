package com.sxtools.sxtoolscanal.dto;

import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Channel;

import java.time.LocalDateTime;

public class ChannelTypeModelDto {

    public static ChannelResponse getResponseCanal() {
        return ChannelResponse.builder()
                .active(Boolean.TRUE)
                .name("Channel")
                .description("Teste Channel")
                .updateDate(String.valueOf(LocalDateTime.now().plusDays(1)))
                .createDate(String.valueOf(LocalDateTime.now()))
                .tenantId(1)
                .groupId(1)
                .createUser("Channel")
                .updateUser("Channel Teste")
                .build();
    }

    public static ChannelRequest getRequestCanal() {
        return ChannelRequest.builder()
                .active(Boolean.TRUE)
                .name("Channel")
                .description("Teste Channel")
                .groupId(1)
                .tenantId(1)
                .build();
    }

    public static Channel getEntityCanal() {
        return Channel.builder()
                .canalAtivo(Boolean.TRUE)
                .nomeCanal("Channel")
                .descricaoCanal("Teste Channel")
                .cdUltimaAtualizacao("Channel Teste")
                .cdUsuarioInclusao("Channel")
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
