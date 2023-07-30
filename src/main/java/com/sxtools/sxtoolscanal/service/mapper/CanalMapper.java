package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Canal;

public class CanalMapper {

    public static CanalResponse convertEntityToDto(Canal canal) {

        return CanalResponse.builder()
                .active(canal.getCanalAtivo())
                .name(canal.getNomeCanal())
                .description(canal.getDescricaoCanal())
                .updateDate(String.valueOf(canal.getDhUltimaAtualizacao()))
                .createDate(String.valueOf(canal.getDhInclusao()))
                .tenantId(canal.getCdTenant())
                .groupId(canal.getSkGrupo())
                .createUser(canal.getCdUsuarioInclusao())
                .updateUser(canal.getCdUltimaAtualizacao())
                .build();
    }

    public static Canal convertRequestToEntity(CanalRequest canalRequest) {
        return Canal.builder()
                .canalAtivo(canalRequest.isActive())
                .nomeCanal(canalRequest.getName())
                .descricaoCanal(canalRequest.getDescription())
                .cdTenant(canalRequest.getTenantId())
                .skGrupo(canalRequest.getGroupId())
                .build();
    }

    public static DtoResponse convertEntityToDtoResponse(Canal canal) {

        return DtoResponse.builder()
                .id(canal.getId())
                .createDate(String.valueOf(canal.getDhInclusao())).build();
    }
}
