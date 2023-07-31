package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.entity.Severity;
import com.sxtools.sxtoolscanal.repository.SeverityRepository;
import com.sxtools.sxtoolscanal.service.impl.SeverityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.dto.SeverityTypeModelDto.getEntitySeverity;
import static com.sxtools.sxtoolscanal.dto.SeverityTypeModelDto.getRequestSeverity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SeverityServiceImplTest {

    @Mock
    private SeverityRepository severityRepository;

    private SeverityServiceImpl severityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        severityService = new SeverityServiceImpl(severityRepository);
    }

    @Test
    void testeListaVazia() {
        when(severityRepository.findAll()).thenReturn(new ArrayList<>());

        List<SeverityResponse> result = severityService.listaSeverities();

        assertTrue(result.isEmpty());
        verify(severityRepository, times(1)).findAll();
    }

    @Test
    void testBuscaListaPreenchida() {

        List<Severity> severities = new ArrayList<>();
        severities.add(getEntitySeverity());
        when(severityRepository.findAll()).thenReturn(severities);

        List<SeverityResponse> result = severityService.listaSeverities();

        assertFalse(result.isEmpty());
        assertEquals(severities.size(), result.size());
        verify(severityRepository, times(1)).findAll();
    }

    @Test
    void getContactMethodIdInexistente() {
        Integer id = 1;
        when(severityRepository.getReferenceById(id)).thenReturn(getEntitySeverity());

        SeverityResponse result = severityService.getSeverityId(id);

        assertNotNull(result);
        verify(severityRepository, times(1)).getReferenceById(id);
    }

    @Test
    void testInsereContactMethod() {
        when(severityRepository.save(any())).thenReturn(getEntitySeverity());
        DtoResponse result = severityService.insereSeverity(getRequestSeverity());
        assertNotNull(result);
    }

    @Test
    void testeAlteraContactMethodInexiustente() {
        Integer id = 1;
        when(severityRepository.findById(id)).thenReturn(Optional.empty());

        Optional<SeverityResponse> result = severityService.alteraSeverity(getRequestSeverity(), id);

        assertTrue(result.isEmpty());
        verify(severityRepository, times(1)).findById(id);
        verify(severityRepository, never()).save(any(Severity.class));
    }

    @Test
    void testeAlteraContactMethodExistente() {
        Integer id = 1;
        Severity severity = getEntitySeverity();
        when(severityRepository.findById(id)).thenReturn(Optional.of(severity));
        when(severityRepository.save(any())).thenReturn(severity);

        Optional<SeverityResponse> result = severityService.alteraSeverity(getRequestSeverity(), id);

        assertTrue(result.isPresent());
        verify(severityRepository, times(1)).findById(id);
        verify(severityRepository, times(1)).save(severity);
    }

}
