package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Channel;
import com.sxtools.sxtoolscanal.repository.ChannelRepository;
import com.sxtools.sxtoolscanal.service.impl.ChannelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.dto.ChannelTypeModelDto.getEntityCanal;
import static com.sxtools.sxtoolscanal.dto.ChannelTypeModelDto.getRequestCanal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChannelServiceImplTest {

    @Mock
    private ChannelRepository channelRepository;

    private ChannelServiceImpl channelServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        channelServiceImpl = new ChannelServiceImpl(channelRepository);
    }

    @Test
    void testeListaVazia() {
        when(channelRepository.findAll()).thenReturn(new ArrayList<>());

        List<ChannelResponse> result = channelServiceImpl.listaCanais();

        assertTrue(result.isEmpty());
        verify(channelRepository, times(1)).findAll();
    }

    @Test
    void testBuscaListaPreenchida() {

        List<Channel> canais = new ArrayList<>();
        canais.add(getEntityCanal());
        when(channelRepository.findAll()).thenReturn(canais);

        List<ChannelResponse> result = channelServiceImpl.listaCanais();

        assertFalse(result.isEmpty());
        assertEquals(canais.size(), result.size());
        verify(channelRepository, times(1)).findAll();
    }

    @Test
    void getCanalIdInexistente() {
        Integer id = 1;
        when(channelRepository.getReferenceById(id)).thenReturn(getEntityCanal());

        ChannelResponse result = channelServiceImpl.getCanalId(id);

        assertNotNull(result);
        verify(channelRepository, times(1)).getReferenceById(id);
    }

    @Test
    void testInsereCanal() {
        when(channelRepository.save(any())).thenReturn(getEntityCanal());
        DtoResponse result = channelServiceImpl.insereCanal(getRequestCanal());
        assertNotNull(result);
    }

    @Test
    void testeAlteraCanalInexiustente() {
        Integer id = 1;
        when(channelRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ChannelResponse> result = channelServiceImpl.alteraCanal(getRequestCanal(), id);

        assertTrue(result.isEmpty());
        verify(channelRepository, times(1)).findById(id);
        verify(channelRepository, never()).save(any(Channel.class));
    }

    @Test
    void testeAlteraCanalExistente() {
        Integer id = 1;
        Channel channel = getEntityCanal();
        when(channelRepository.findById(id)).thenReturn(Optional.of(channel));
        when(channelRepository.save(any())).thenReturn(channel);

        Optional<ChannelResponse> result = channelServiceImpl.alteraCanal(getRequestCanal(), id);

        assertTrue(result.isPresent());
        verify(channelRepository, times(1)).findById(id);
        verify(channelRepository, times(1)).save(channel);
    }

    @Test
    void testExcluirCanalValido() {
        Integer id = 1;
        channelServiceImpl.excluirCanal(id);
        verify(channelRepository, times(1)).deleteById(id);
    }
}
