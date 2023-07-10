package com.sxtools.sxtoolscanal.service.mapper;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.entity.Canal;

public class CanalMapper {

    public static CanalResponse convertEntityToDto(Canal canal){

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

    public static Canal convertRequestToEntity(CanalRequest canalRequest){
       return Canal.builder()
                .canalAtivo(canalRequest.getCanalAtivo())
                .nomeCanal(canalRequest.getNomeCanal())
                .descricaoCanal(canalRequest.getDescricaoCanal())
                .cdUltimaAtualizacao(canalRequest.getCdUltimaAtualizacao())
                .cdUsuarioInclusao(canalRequest.getCdUsuarioInclusao())
                .dhInclusao(canalRequest.getDhInclusao())
                .dhUltimaAtualizacao(canalRequest.getDhUltimaAtualizacao())
                .build();
    }
}
