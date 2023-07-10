package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;

import java.util.List;
import java.util.Optional;

public interface CanalService {

    List<CanalResponse> listaCanais ();

    CanalResponse getCanalId(Integer id);

    CanalResponse insereCanal(CanalRequest canalRequest);

    Optional<CanalResponse> alteraCanal(CanalRequest canalRequest, Integer id);

    void excluirCanal(Integer id);
}
