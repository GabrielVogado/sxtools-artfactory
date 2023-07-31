package com.sxtools.sxtoolscanal.dto;

import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.entity.Severity;

import java.time.LocalDateTime;

public class SeverityTypeModelDto {

    public static SeverityResponse getResponseSeverity() {
        return SeverityResponse.builder()
                .active(Boolean.TRUE)
                .name("Severity")
                .description("Teste Severity")
                .updateDate(String.valueOf(LocalDateTime.now().plusDays(1)))
                .createDate(String.valueOf(LocalDateTime.now()))
                .createUser("Severity")
                .updateUser("Severity Teste")
                .build();
    }

    public static SeverityRequest getRequestSeverity() {
        return SeverityRequest.builder()
                .active(Boolean.TRUE)
                .name("Severity")
                .description("Teste Severity")
                .build();
    }

    public static Severity getEntitySeverity() {
        return Severity.builder()
                .inSeveridade(Boolean.TRUE)
                .nomeSeveridade("Severity")
                .dsSeveridade("Teste Severity")
                .cdUltimaAtualizacao("Severity Teste")
                .cdUsuarioInclusao("Severity")
                .dhInclusao(LocalDateTime.now())
                .dhUltimaAtualizacao(LocalDateTime.now().plusDays(1))
                .build();
    }

    public static DtoResponse getResponseSeverityDto() {
        return DtoResponse.builder()
                .id(1)
                .createDate(String.valueOf(LocalDateTime.now())).build();
    }
}
