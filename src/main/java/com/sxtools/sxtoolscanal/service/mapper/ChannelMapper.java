package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Channel;

public class ChannelMapper {

    public static ChannelResponse convertEntityToDto(Channel channel) {

        return ChannelResponse.builder()
                .active(channel.getCanalAtivo())
                .name(channel.getNomeCanal())
                .description(channel.getDescricaoCanal())
                .updateDate(String.valueOf(channel.getDhUltimaAtualizacao()))
                .createDate(String.valueOf(channel.getDhInclusao()))
                .tenantId(channel.getCdTenant())
                .groupId(channel.getSkGrupo())
                .createUser(channel.getCdUsuarioInclusao())
                .updateUser(channel.getCdUltimaAtualizacao())
                .build();
    }

    public static Channel convertRequestToEntity(ChannelRequest channelRequest) {
        return Channel.builder()
                .canalAtivo(channelRequest.isActive())
                .nomeCanal(channelRequest.getName())
                .descricaoCanal(channelRequest.getDescription())
                .cdTenant(channelRequest.getTenantId())
                .skGrupo(channelRequest.getGroupId())
                .build();
    }

    public static DtoResponse convertEntityToDtoResponse(Channel channel) {

        return DtoResponse.builder()
                .id(channel.getId())
                .createDate(String.valueOf(channel.getDhInclusao())).build();
    }
}
