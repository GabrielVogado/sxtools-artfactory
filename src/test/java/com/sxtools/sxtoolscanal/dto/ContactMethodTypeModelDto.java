package com.sxtools.sxtoolscanal.dto;

import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.ContactMethod;

import java.time.LocalDateTime;

public class ContactMethodTypeModelDto {

    public static ContactMethodResponse getResponseContactMethod() {
        return ContactMethodResponse.builder()
                .active(Boolean.TRUE)
                .name("ContactMethod")
                .description("Teste ContactMethod")
                .updateDate(String.valueOf(LocalDateTime.now().plusDays(1)))
                .createDate(String.valueOf(LocalDateTime.now()))
                .createUser("ContactMethod")
                .updateUser("ContactMethod Teste")
                .build();
    }

    public static ContactMethodRequest getRequestContactMethod() {
        return ContactMethodRequest.builder()
                .active(Boolean.TRUE)
                .name("ContactMethod")
                .description("Teste ContactMethod")
                .build();
    }

    public static ContactMethod getEntityContactMethod() {
        return ContactMethod.builder()
                .inMethodContact(Boolean.TRUE)
                .nmMethodContact("ContactMethod")
                .dsMethodContact("Teste ContactMethod")
                .cdUltimaAtualizacao("ContactMethod Teste")
                .cdUsuarioInclusao("ContactMethod")
                .dhInclusao(LocalDateTime.now())
                .dhUltimaAtualizacao(LocalDateTime.now().plusDays(1))
                .build();
    }

    public static DtoResponse getResponseContactMethodDto() {
        return DtoResponse.builder()
                .id(1)
                .createDate(String.valueOf(LocalDateTime.now())).build();
    }
}
