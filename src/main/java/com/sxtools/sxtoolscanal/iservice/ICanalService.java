package com.sxtools.sxtoolscanal.iservice;

import com.sxtools.sxtoolscanal.request.CanalRequest;
import com.sxtools.sxtoolscanal.response.CanalResponse;

import java.util.List;
import java.util.Optional;

public interface ICanalService {

    List<CanalResponse> listaCanais ();

    CanalResponse getCanalId(Integer id);

    CanalResponse insereCanal(CanalRequest canalRequest);

    Optional<CanalResponse> alteraCanal(CanalRequest canalRequest, Integer id);

    void excluirCanal(Integer id);
}
