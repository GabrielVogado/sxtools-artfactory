package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.service.SeverityService;
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

import static com.sxtools.sxtoolscanal.dto.SeverityTypeModelDto.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SeverityControllerTest {

    @Mock
    private SeverityService severityService;

    @InjectMocks
    private SeverityController severityController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListaCanais() {
        List<SeverityResponse> severityResponseList = new ArrayList<>();
        severityResponseList.add((getResponseSeverity()));
        severityResponseList.add(getResponseSeverity());

        when(severityService.listaSeverities()).thenReturn(severityResponseList);

        List<SeverityResponse> responseList = severityController.listSeverities().getBody();

        assertEquals(severityResponseList, responseList);
    }

    @Test
    public void testBuscaSeverityExistente() {
        SeverityResponse response = getResponseSeverity();
        Mockito.when(severityService.getSeverityId(1)).thenReturn(response);
        SeverityResponse resultado = severityController.getSeverityId(1).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testBuscaSeverityInexistente() {
        Mockito.when(severityService.getSeverityId(1)).thenReturn(any());
        ResponseEntity<SeverityResponse> resultado = severityController.getSeverityId(1);
        assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
    }

    @Test
    public void testInsereSeverity() {

        SeverityRequest request = getRequestSeverity();
        DtoResponse response = getResponseSeverityDto();
        Mockito.when(severityService.insereSeverity(request)).thenReturn(response);
        DtoResponse resultado = severityController.insereSeverity(request).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testAlteraSeverityExistente() {
        Integer id = 1;
        SeverityRequest request = getRequestSeverity();
        Optional<SeverityResponse> response = Optional.of(getResponseSeverity());
        when(severityService.alteraSeverity(request, id)).thenReturn(response);

        ResponseEntity<Optional<SeverityResponse>> result = severityController.alteraSeverity(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
        verify(severityService, times(1)).alteraSeverity(request, id);
    }

    @Test
    public void TestAlteraSeverityInexistente() {
        Integer id = 1;
        SeverityRequest request = new SeverityRequest();
        Optional<SeverityResponse> response = Optional.empty();
        when(severityService.alteraSeverity(request, id)).thenReturn(response);

        ResponseEntity<Optional<SeverityResponse>> result = severityController.alteraSeverity(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNull(result.getBody());
        verify(severityService, times(1)).alteraSeverity(request, id);
    }
}
