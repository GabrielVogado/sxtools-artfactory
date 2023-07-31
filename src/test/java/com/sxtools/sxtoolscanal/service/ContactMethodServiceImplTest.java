package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.ContactMethod;
import com.sxtools.sxtoolscanal.repository.ContactMethodRepository;
import com.sxtools.sxtoolscanal.service.impl.ContactMethodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.dto.ContactMethodTypeModelDto.getEntityContactMethod;
import static com.sxtools.sxtoolscanal.dto.ContactMethodTypeModelDto.getRequestContactMethod;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContactMethodServiceImplTest {

    @Mock
    private ContactMethodRepository contactMethodRepository;

    private ContactMethodServiceImpl contactMethodService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        contactMethodService = new ContactMethodServiceImpl(contactMethodRepository);
    }

    @Test
    void testeListaVazia() {
        when(contactMethodRepository.findAll()).thenReturn(new ArrayList<>());

        List<ContactMethodResponse> result = contactMethodService.listaContactMethods();

        assertTrue(result.isEmpty());
        verify(contactMethodRepository, times(1)).findAll();
    }

    @Test
    void testBuscaListaPreenchida() {

        List<ContactMethod> contactMethods = new ArrayList<>();
        contactMethods.add(getEntityContactMethod());
        when(contactMethodRepository.findAll()).thenReturn(contactMethods);

        List<ContactMethodResponse> result = contactMethodService.listaContactMethods();

        assertFalse(result.isEmpty());
        assertEquals(contactMethods.size(), result.size());
        verify(contactMethodRepository, times(1)).findAll();
    }

    @Test
    void getContactMethodIdInexistente() {
        Integer id = 1;
        when(contactMethodRepository.getReferenceById(id)).thenReturn(getEntityContactMethod());

        ContactMethodResponse result = contactMethodService.getContactMethodId(id);

        assertNotNull(result);
        verify(contactMethodRepository, times(1)).getReferenceById(id);
    }

    @Test
    void testInsereContactMethod() {
        when(contactMethodRepository.save(any())).thenReturn(getEntityContactMethod());
        DtoResponse result = contactMethodService.insereContactMethod(getRequestContactMethod());
        assertNotNull(result);
    }

    @Test
    void testeAlteraContactMethodInexiustente() {
        Integer id = 1;
        when(contactMethodRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ContactMethodResponse> result = contactMethodService.alteraContactMethod(getRequestContactMethod(), id);

        assertTrue(result.isEmpty());
        verify(contactMethodRepository, times(1)).findById(id);
        verify(contactMethodRepository, never()).save(any(ContactMethod.class));
    }

    @Test
    void testeAlteraContactMethodExistente() {
        Integer id = 1;
        ContactMethod contactMethod = getEntityContactMethod();
        when(contactMethodRepository.findById(id)).thenReturn(Optional.of(contactMethod));
        when(contactMethodRepository.save(any())).thenReturn(contactMethod);

        Optional<ContactMethodResponse> result = contactMethodService.alteraContactMethod(getRequestContactMethod(), id);

        assertTrue(result.isPresent());
        verify(contactMethodRepository, times(1)).findById(id);
        verify(contactMethodRepository, times(1)).save(contactMethod);
    }

}
