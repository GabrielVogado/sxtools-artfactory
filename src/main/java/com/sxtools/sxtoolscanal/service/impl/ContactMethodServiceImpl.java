package com.sxtools.sxtoolscanal.service.impl;

import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.ContactMethod;
import com.sxtools.sxtoolscanal.repository.ContactMethodRepository;
import com.sxtools.sxtoolscanal.service.ContactMethodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.service.mapper.ContactMethodMapper.*;


@Service
public class ContactMethodServiceImpl implements ContactMethodService {

    private final ContactMethodRepository contactMethodRepository;


    @Autowired
    public ContactMethodServiceImpl(ContactMethodRepository contactMethodRepository) {
        this.contactMethodRepository = contactMethodRepository;
    }


    /**
     * @return
     */
    @Override
    public List<ContactMethodResponse> listaContactMethods() {

        List<ContactMethod> entity = contactMethodRepository.findAll();
        List<ContactMethodResponse> responseList = new ArrayList<>();
        for (ContactMethod contactMethod : entity) {
            responseList.add(convertEntityToDto(contactMethod));
        }
        return responseList;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ContactMethodResponse getContactMethodId(Integer id) {
        ContactMethod contactMethod = contactMethodRepository.getReferenceById(id);
        return convertEntityToDto(contactMethod);
    }

    /**
     * @param contactMethodRequest
     * @return
     */
    @Override
    public DtoResponse insereContactMethod(ContactMethodRequest contactMethodRequest) {
        ContactMethod contactMethod = convertRequestToEntity(contactMethodRequest);
        return convertEntityToDtoResponse(contactMethodRepository.save(contactMethod));
    }

    /**
     * @param contactMethodRequest
     * @param id
     * @return
     */
    @Override
    public Optional<ContactMethodResponse> alteraContactMethod(ContactMethodRequest contactMethodRequest, Integer id) {
        return contactMethodRepository.findById(id).map(
                contactMethod -> {
                    BeanUtils.copyProperties(contactMethodRequest, contactMethod, "id");
                    ContactMethod contactMethodUpdate = contactMethodRepository.save(contactMethod);
                    return convertEntityToDto(contactMethodUpdate);
                }
        );
    }
}
