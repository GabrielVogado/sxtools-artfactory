package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.config.ContactMethodDocument;
import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.service.ContactMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/methods")
public class ContactMethodController implements ContactMethodDocument {

    private final ContactMethodService contactMethodService;

    @Autowired
    public ContactMethodController(ContactMethodService contactMethodService) {
        this.contactMethodService = contactMethodService;
    }


    /**
     * @return
     */
    @Override
    @GetMapping
    public ResponseEntity<List<ContactMethodResponse>> listContactMethods() {
        List<ContactMethodResponse> listaContactMethods = contactMethodService.listaContactMethods();
        if(!listaContactMethods.isEmpty()){
            return  ResponseEntity.status(HttpStatus.OK).body(listaContactMethods);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listaContactMethods);
    }

    /**
     * @param id
     * @return
     */
    @Override
    @GetMapping("/{contact_method_id}")
    public ResponseEntity<ContactMethodResponse> getContactMethodId(@PathVariable(name = "contact_method_id") Integer id) {

        ContactMethodResponse response = contactMethodService.getContactMethodId(id);

        if (!ObjectUtils.isEmpty(response)){
            ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    /**
     * @param contactMethodRequest
     * @return
     */
    @Override
    @PostMapping
    public ResponseEntity<DtoResponse> insereContactMethod(@RequestBody ContactMethodRequest contactMethodRequest) {
        DtoResponse response = contactMethodService.insereContactMethod(contactMethodRequest);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * @param contactMethodRequest
     * @param id
     * @return
     */
    @Override
    @PutMapping("/{contact_method_id}")
    public ResponseEntity<Optional<ContactMethodResponse>> alteraContactMethod(@RequestBody ContactMethodRequest contactMethodRequest, @PathVariable(name = "contact_method_id") Integer id) {

        Optional<ContactMethodResponse> response = contactMethodService.alteraContactMethod(contactMethodRequest,id);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
