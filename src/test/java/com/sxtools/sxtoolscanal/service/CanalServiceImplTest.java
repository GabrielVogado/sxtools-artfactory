package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Canal;
import com.sxtools.sxtoolscanal.repository.CanalRepository;
import com.sxtools.sxtoolscanal.service.impl.CanalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.dto.CanalTypeModelDto.getEntityCanal;
import static com.sxtools.sxtoolscanal.dto.CanalTypeModelDto.getRequestCanal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CanalServiceImplTest {

    @Mock
    private CanalRepository canalRepository;

    private CanalServiceImpl canalServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        canalServiceImpl = new CanalServiceImpl(canalRepository);
    }

    @Test
    void testeListaVazia() {
        when(canalRepository.findAll()).thenReturn(new ArrayList<>());

        List<CanalResponse> result = canalServiceImpl.listaCanais();

        assertTrue(result.isEmpty());
        verify(canalRepository, times(1)).findAll();
    }

    @Test
    void testBuscaListaPreenchida() {

        List<Canal> canais = new ArrayList<>();
        canais.add(getEntityCanal());
        when(canalRepository.findAll()).thenReturn(canais);

        List<CanalResponse> result = canalServiceImpl.listaCanais();

        assertFalse(result.isEmpty());
        assertEquals(canais.size(), result.size());
        verify(canalRepository, times(1)).findAll();
    }

    @Test
    void getCanalIdInexistente() {
        Integer id = 1;
        when(canalRepository.getReferenceById(id)).thenReturn(getEntityCanal());

        CanalResponse result = canalServiceImpl.getCanalId(id);

        assertNotNull(result);
        verify(canalRepository, times(1)).getReferenceById(id);
    }

    @Test
    void testInsereCanal() {
        when(canalRepository.save(any())).thenReturn(getEntityCanal());
        DtoResponse result = canalServiceImpl.insereCanal(getRequestCanal());
        assertNotNull(result);
    }

    @Test
    void testeAlteraCanalInexiustente() {
        Integer id = 1;
        when(canalRepository.findById(id)).thenReturn(Optional.empty());

        Optional<CanalResponse> result = canalServiceImpl.alteraCanal(getRequestCanal(), id);

        assertTrue(result.isEmpty());
        verify(canalRepository, times(1)).findById(id);
        verify(canalRepository, never()).save(any(Canal.class));
    }

    @Test
    void testeAlteraCanalExistente() {
        Integer id = 1;
        Canal canal = getEntityCanal();
        when(canalRepository.findById(id)).thenReturn(Optional.of(canal));
        when(canalRepository.save(any())).thenReturn(canal);

        Optional<CanalResponse> result = canalServiceImpl.alteraCanal(getRequestCanal(), id);

        assertTrue(result.isPresent());
        verify(canalRepository, times(1)).findById(id);
        verify(canalRepository, times(1)).save(canal);
    }

    @Test
    void testExcluirCanalValido() {
        Integer id = 1;
        canalServiceImpl.excluirCanal(id);
        verify(canalRepository, times(1)).deleteById(id);
    }
}
