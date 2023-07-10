package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.entity.Canal;
import com.sxtools.sxtoolscanal.iservice.ICanalService;
import com.sxtools.sxtoolscanal.repository.CanalRepository;
import com.sxtools.sxtoolscanal.request.CanalRequest;
import com.sxtools.sxtoolscanal.response.CanalResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CanalService implements ICanalService {

    private final CanalRepository canalRepository;

    @Autowired
    public CanalService(CanalRepository canalRepository) {
        this.canalRepository = canalRepository;
    }


    /**
     * @return
     */
    @Override
    public List<CanalResponse> listaCanais() {

        List<Canal> entity = canalRepository.findAll();
        List<CanalResponse> responseList = new ArrayList<>();
        for (Canal canal : entity){
            CanalResponse response = CanalResponse.builder()
                    .canalAtivo(canal.getCanalAtivo())
                    .nomeCanal(canal.getNomeCanal())
                    .descricaoCanal(canal.getDescricaoCanal())
                    .cdUltimaAtualizacao(canal.getCdUltimaAtualizacao())
                    .cdUsuarioInclusao(canal.getCdUsuarioInclusao())
                    .dhInclusao(canal.getDhInclusao())
                    .dhUltimaAtualizacao(canal.getDhUltimaAtualizacao())
                    .build();
            responseList.add(response);

        }

        return responseList;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public CanalResponse getCanalId(Integer id) {
        Canal canal = canalRepository.getReferenceById(id);

        return CanalResponse.builder()
                .canalAtivo(canal.getCanalAtivo())
                .nomeCanal(canal.getNomeCanal())
                .descricaoCanal(canal.getDescricaoCanal())
                .cdUltimaAtualizacao(canal.getCdUltimaAtualizacao())
                .cdUsuarioInclusao(canal.getCdUsuarioInclusao())
                .dhInclusao(canal.getDhInclusao())
                .dhUltimaAtualizacao(canal.getDhUltimaAtualizacao())
                .build();
    }

    /**
     * @param canalRequest
     * @return
     */
    @Override
    public CanalResponse insereCanal(CanalRequest canalRequest) {
       return CanalResponse.builder()
                .canalAtivo(canalRequest.getCanalAtivo())
                .nomeCanal(canalRequest.getNomeCanal())
                .descricaoCanal(canalRequest.getDescricaoCanal())
                .cdUltimaAtualizacao(canalRequest.getCdUltimaAtualizacao())
                .cdUsuarioInclusao(canalRequest.getCdUsuarioInclusao())
                .dhInclusao(canalRequest.getDhInclusao())
                .dhUltimaAtualizacao(canalRequest.getDhUltimaAtualizacao())
                .build();
    }

    /**
     * @param canalRequest
     * @return
     */
    @Override
    public Optional<CanalResponse> alteraCanal(CanalRequest canalRequest, Integer id) {
        return canalRepository.findById(id).map(
                canal -> {
                    BeanUtils.copyProperties(canalRequest, canal, "id");
                    Canal canalUpdate = canalRepository.save(canal);
                    return CanalResponse.builder()
                            .canalAtivo(canalUpdate.getCanalAtivo())
                            .nomeCanal(canalUpdate.getNomeCanal())
                            .descricaoCanal(canalUpdate.getDescricaoCanal())
                            .cdUltimaAtualizacao(canalUpdate.getCdUltimaAtualizacao())
                            .cdUsuarioInclusao(canalUpdate.getCdUsuarioInclusao())
                            .dhInclusao(canalUpdate.getDhInclusao())
                            .dhUltimaAtualizacao(canalUpdate.getDhUltimaAtualizacao())
                            .build();
                }
        );
    }

    /**
     *
     */
    @Override
    public void excluirCanal(Integer id) {
        canalRepository.deleteById(id);
    }
}
