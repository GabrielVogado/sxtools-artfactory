package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.entity.Canal;
import com.sxtools.sxtoolscanal.repository.CanalRepository;
import com.sxtools.sxtoolscanal.request.CanalRequest;
import com.sxtools.sxtoolscanal.response.CanalResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CanalServiceTest {

    @Mock
    private CanalRepository canalRepository;

    private CanalService canalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        canalService = new CanalService(canalRepository);
    }

    @Test
    void listaCanais_DeveRetornarListaVazia_QuandoNaoExistemCanais() {
        when(canalRepository.findAll()).thenReturn(new ArrayList<>());

        List<CanalResponse> result = canalService.listaCanais();

        assertTrue(result.isEmpty());
        verify(canalRepository, times(1)).findAll();
    }

    @Test
    void listaCanais_DeveRetornarListaDeCanais_QuandoExistemCanais() {

        List<Canal> canais = new ArrayList<>();
        canais.add(new Canal());
        when(canalRepository.findAll()).thenReturn(canais);

        List<CanalResponse> result = canalService.listaCanais();

        assertFalse(result.isEmpty());
        assertEquals(canais.size(), result.size());
        verify(canalRepository, times(1)).findAll();
    }

    @Test
    void getCanalId_DeveRetornarCanal_QuandoExisteId() {
        Integer id = 1;
        Canal canal = new Canal();
        when(canalRepository.getReferenceById(id)).thenReturn(canal);

        CanalResponse result = canalService.getCanalId(id);

        assertNotNull(result);
        verify(canalRepository, times(1)).getReferenceById(id);
    }

    @Test
    void insereCanal_DeveRetornarCanalResponse_ComOsDadosInseridos() {
        CanalRequest request = new CanalRequest();

        CanalResponse result = canalService.insereCanal(request);

        assertNotNull(result);
    }

    @Test
    void alteraCanal_DeveRetornarOptionalVazio_QuandoCanalNaoExiste() {
        Integer id = 1;
        CanalRequest request = new CanalRequest();
        when(canalRepository.findById(id)).thenReturn(Optional.empty());

        Optional<CanalResponse> result = canalService.alteraCanal(request, id);

        assertTrue(result.isEmpty());
        verify(canalRepository, times(1)).findById(id);
        verify(canalRepository, never()).save(any(Canal.class));
    }

    @Test
    void alteraCanal_DeveRetornarOptionalComCanalResponse_QuandoCanalExiste() {
        Integer id = 1;
        CanalRequest request = new CanalRequest();
        Canal canal = new Canal();
        when(canalRepository.findById(id)).thenReturn(Optional.of(canal));
        when(canalRepository.save(canal)).thenReturn(canal);

        Optional<CanalResponse> result = canalService.alteraCanal(request, id);

        assertTrue(result.isPresent());
        verify(canalRepository, times(1)).findById(id);
        verify(canalRepository, times(1)).save(canal);
    }

    @Test
    void excluirCanal_DeveChamarDeleteById_QuandoIdValido() {

        Integer id = 1;
        canalService.excluirCanal(id);
        verify(canalRepository, times(1)).deleteById(id);
    }
}
