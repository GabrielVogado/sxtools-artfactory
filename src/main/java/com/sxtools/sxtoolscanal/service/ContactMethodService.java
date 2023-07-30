package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;

import java.util.List;
import java.util.Optional;

public interface ContactMethodService {
    List<ContactMethodResponse> listaContactMethods();

    ContactMethodResponse getContactMethodId(Integer id);

    DtoResponse insereContactMethod(ContactMethodRequest contactMethodRequest);

    Optional<ContactMethodResponse> alteraContactMethod(ContactMethodRequest contactMethodRequest, Integer id);
}
