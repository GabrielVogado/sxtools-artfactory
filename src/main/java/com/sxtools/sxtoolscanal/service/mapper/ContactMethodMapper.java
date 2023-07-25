package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.entity.ContactMethod;
import com.sxtools.sxtoolscanal.entity.Severity;

public class ContactMethodMapper {

    public static ContactMethodResponse convertEntityToDto(ContactMethod contactMethod) {

        return ContactMethodResponse.builder()
                .name(contactMethod.getNmMethodContact())
                .description(String.valueOf(contactMethod.getDsMethodContact()))
                .active(contactMethod.getInMethodContact())
                .build();
    }

    public static ContactMethod convertRequestToEntity(ContactMethodRequest contactMethodRequest) {
        return ContactMethod .builder()
                .skMethodContact(null)
                .nmMethodContact(contactMethodRequest.getName())
                .dsMethodContact(contactMethodRequest.getDescription())
                .cdUltimaAtualizacao(null)
                .cdUsuarioInclusao(null)
                .dhInclusao(null)
                .dhUltimaAtualizacao(null)
                .build();
    }
}
