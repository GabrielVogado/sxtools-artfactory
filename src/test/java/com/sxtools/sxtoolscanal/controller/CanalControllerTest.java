package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.service.CanalService;
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

import static com.sxtools.sxtoolscanal.dto.CanalTypeModelDto.getRequestCanal;
import static com.sxtools.sxtoolscanal.dto.CanalTypeModelDto.getResponseCanal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CanalControllerTest {

    @Mock
    private CanalService canalService;

    @InjectMocks
    private CanalController canalController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListaCanais() {
        List<CanalResponse> canalResponseList = new ArrayList<>();
        canalResponseList.add(getResponseCanal());
        canalResponseList.add(getResponseCanal());

        when(canalService.listaCanais()).thenReturn(canalResponseList);

        List<CanalResponse> responseList = canalController.listaCanais().getBody();

        assertEquals(canalResponseList, responseList);
    }

    @Test
    public void testBuscaCanalExistente() {
        CanalResponse response = getResponseCanal();
        Mockito.when(canalService.getCanalId(1)).thenReturn(response);
        CanalResponse resultado = canalController.getCanalId(1).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testBuscaCanalInexistente() {
        Mockito.when(canalService.getCanalId(1)).thenReturn(any());
        ResponseEntity<CanalResponse> resultado = canalController.getCanalId(1);
        assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
    }

    @Test
    public void testInsereCanal() {

        CanalRequest request = getRequestCanal();
        CanalResponse response = getResponseCanal();
        Mockito.when(canalService.insereCanal(request)).thenReturn(response);
        CanalResponse resultado = canalController.insereCanal(request).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testAlteraCanalExistente() {
        Integer id = 1;
        CanalRequest request = getRequestCanal();
        Optional<CanalResponse> response = Optional.of(getResponseCanal());
        when(canalService.alteraCanal(request, id)).thenReturn(response);

        ResponseEntity<Optional<CanalResponse>> result = canalController.alteraCanal(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
        verify(canalService, times(1)).alteraCanal(request, id);
    }

    @Test
    public void TestAlteraCanalInexistente() {
        Integer id = 1;
        CanalRequest request = new CanalRequest();
        Optional<CanalResponse> response = Optional.empty();
        when(canalService.alteraCanal(request, id)).thenReturn(response);

        ResponseEntity<Optional<CanalResponse>> result = canalController.alteraCanal(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNull(result.getBody());
        verify(canalService, times(1)).alteraCanal(request, id);
    }

}
