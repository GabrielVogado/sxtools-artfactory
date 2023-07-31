package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.service.ChannelService;
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

import static com.sxtools.sxtoolscanal.dto.ChannelTypeModelDto.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ChannelControllerTest {

    @Mock
    private ChannelService channelService;

    @InjectMocks
    private ChannelController channelController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListaCanais() {
        List<ChannelResponse> channelResponseList = new ArrayList<>();
        channelResponseList.add(getResponseCanal());
        channelResponseList.add(getResponseCanal());

        when(channelService.listaCanais()).thenReturn(channelResponseList);

        List<ChannelResponse> responseList = channelController.listaCanais().getBody();

        assertEquals(channelResponseList, responseList);
    }

    @Test
    public void testBuscaCanalExistente() {
        ChannelResponse response = getResponseCanal();
        Mockito.when(channelService.getCanalId(1)).thenReturn(response);
        ChannelResponse resultado = channelController.getCanalId(1).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testBuscaCanalInexistente() {
        Mockito.when(channelService.getCanalId(1)).thenReturn(any());
        ResponseEntity<ChannelResponse> resultado = channelController.getCanalId(1);
        assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
    }

    @Test
    public void testInsereCanal() {

        ChannelRequest request = getRequestCanal();
        DtoResponse response = getResponseCanalDto();
        Mockito.when(channelService.insereCanal(request)).thenReturn(response);
        DtoResponse resultado = channelController.insereCanal(request).getBody();
        assertEquals(response, resultado);
    }

    @Test
    public void testAlteraCanalExistente() {
        Integer id = 1;
        ChannelRequest request = getRequestCanal();
        Optional<ChannelResponse> response = Optional.of(getResponseCanal());
        when(channelService.alteraCanal(request, id)).thenReturn(response);

        ResponseEntity<Optional<ChannelResponse>> result = channelController.alteraCanal(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
        verify(channelService, times(1)).alteraCanal(request, id);
    }

    @Test
    public void TestAlteraCanalInexistente() {
        Integer id = 1;
        ChannelRequest request = new ChannelRequest();
        Optional<ChannelResponse> response = Optional.empty();
        when(channelService.alteraCanal(request, id)).thenReturn(response);

        ResponseEntity<Optional<ChannelResponse>> result = channelController.alteraCanal(request, id);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNull(result.getBody());
        verify(channelService, times(1)).alteraCanal(request, id);
    }

    @Test
    public void testExcluirCanal() {
        Integer canalId = 1;
        channelController.excluirCanal(canalId);
        verify(channelService).excluirCanal(canalId);
    }

}
