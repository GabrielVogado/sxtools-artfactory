package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.service.ContactMethodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.dto.ContactMethodTypeModelDto.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ContactMethodControllerTest {

    @Mock
    private ContactMethodService contactMethodService;

    @InjectMocks
    private ContactMethodController contactMethodController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListaCanais() {
        List<ContactMethodResponse> contactMethodResponseList = new ArrayList<>();
        contactMethodResponseList.add(getResponseContactMethod());
        contactMethodResponseList.add(getResponseContactMethod());

        when(contactMethodService.listaContactMethods()).thenReturn(contactMethodResponseList);

        List<ContactMethodResponse> responseList = contactMethodController.listContactMethods().getBody();

        assertEquals(contactMethodResponseList, responseList);
    }

    @Test
    public void testBuscaContactMethodExistente() {
        ContactMethodResponse response = getResponseContactMethod();
        Mockito.when(contactMethodService.getContactMethodId(1)).thenReturn(response);
        ContactMethodResponse resultado = contactMethodController.getContactMethodId(1).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testBuscaContactMethodInexistente() {
        Mockito.when(contactMethodService.getContactMethodId(1)).thenReturn(any());
        ResponseEntity<ContactMethodResponse> resultado = contactMethodController.getContactMethodId(1);
        assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
    }

    @Test
    public void testInsereContactMethod() {

        ContactMethodRequest request = getRequestContactMethod();
        DtoResponse response = getResponseContactMethodDto();
        Mockito.when(contactMethodService.insereContactMethod(request)).thenReturn(response);
        DtoResponse resultado = contactMethodController.insereContactMethod(request).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testAlteraContactMethodExistente() {
        Integer id = 1;
        ContactMethodRequest request = getRequestContactMethod();
        Optional<ContactMethodResponse> response = Optional.of(getResponseContactMethod());
        when(contactMethodService.alteraContactMethod(request, id)).thenReturn(response);

        ResponseEntity<Optional<ContactMethodResponse>> result = contactMethodController.alteraContactMethod(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
        verify(contactMethodService, times(1)).alteraContactMethod(request, id);
    }

    @Test
    public void TestAlteraContactMethodInexistente() {
        Integer id = 1;
        ContactMethodRequest request = new ContactMethodRequest();
        Optional<ContactMethodResponse> response = Optional.empty();
        when(contactMethodService.alteraContactMethod(request, id)).thenReturn(response);

        ResponseEntity<Optional<ContactMethodResponse>> result = contactMethodController.alteraContactMethod(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNull(result.getBody());
        verify(contactMethodService, times(1)).alteraContactMethod(request, id);
    }
}
