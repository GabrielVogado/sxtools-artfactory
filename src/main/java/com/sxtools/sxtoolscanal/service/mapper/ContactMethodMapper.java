package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.ContactMethod;

public class ContactMethodMapper {

    public static ContactMethodResponse convertEntityToDto(ContactMethod contactMethod) {

        return ContactMethodResponse.builder()
                .active(contactMethod.getInMethodContact())
                .name(contactMethod.getNmMethodContact())
                .description(contactMethod.getDsMethodContact())
                .updateDate(String.valueOf(contactMethod.getDhUltimaAtualizacao()))
                .createDate(String.valueOf(contactMethod.getDhInclusao()))
                .createUser(contactMethod.getCdUsuarioInclusao())
                .updateUser(contactMethod.getCdUltimaAtualizacao())
                .build();
    }

    public static ContactMethod convertRequestToEntity(ContactMethodRequest contactMethodRequest) {
        return ContactMethod.builder()
                .inMethodContact(contactMethodRequest.isActive())
                .nmMethodContact(contactMethodRequest.getName())
                .dsMethodContact(contactMethodRequest.getDescription())
                .build();
    }

    public static DtoResponse convertEntityToDtoResponse(ContactMethod contactMethod) {

        return DtoResponse.builder()
                .id(contactMethod.getSkMethodContact())
                .createDate(String.valueOf(contactMethod.getDhInclusao())).build();
    }
}
