package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.entity.Canal;
import com.sxtools.sxtoolscanal.entity.Severity;

import java.time.LocalDateTime;

public class SeverityMapper {

    public static SeverityResponse convertEntityToDto(Severity severity){

        return SeverityResponse.builder()
                .createDate(severity.getCdUltimaAtualizacao())
                .severityId(severity.getId())
                .build();
    }

    public static Severity convertRequestToEntity(SeverityRequest severityRequest){
       return Severity.builder()
                .hrSlaSeveridade(severityRequest.getHour())
                .nomeSeveridade(severityRequest.getName())
                .dsSeveridade(severityRequest.getDescription())
                .cdUltimaAtualizacao(severityRequest.getUpdateDate())
                .cdUsuarioInclusao(severityRequest.getCreateUser())
                .dhInclusao(LocalDateTime.parse(severityRequest.getCreateDate()))
                .dhUltimaAtualizacao(LocalDateTime.parse(severityRequest.getUpdateDate()))
                .build();
    }
}
