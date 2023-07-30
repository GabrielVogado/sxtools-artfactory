package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.entity.Severity;

public class SeverityMapper {

    public static SeverityResponse convertEntityToDto(Severity severity) {

        return SeverityResponse.builder()
                .active(severity.getInSeveridade())
                .name(severity.getNomeSeveridade())
                .description(severity.getDsSeveridade())
                .updateUser(severity.getCdUltimaAtualizacao())
                .createUser(severity.getCdUsuarioInclusao())
                .createDate(String.valueOf(severity.getDhInclusao()))
                .updateDate(String.valueOf(severity.getDhUltimaAtualizacao()))
                .build();
    }

    public static Severity convertRequestToEntity(SeverityRequest severityRequest) {
        return Severity.builder()
                .hrSlaSeveridade(severityRequest.getHour())
                .nomeSeveridade(severityRequest.getName())
                .dsSeveridade(severityRequest.getDescription())
                .cdTenant(String.valueOf(severityRequest.getTenantId()))
                .skGrupo(severityRequest.getGroupId())
                .build();
    }

    public static DtoResponse convertEntityToDtoResponse(Severity severity) {

        return DtoResponse.builder()
                .id(severity.getId())
                .createDate(String.valueOf(severity.getDhInclusao())).build();
    }
}
