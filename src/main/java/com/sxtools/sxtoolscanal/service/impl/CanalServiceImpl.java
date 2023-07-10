package com.sxtools.sxtoolscanal.service.impl;

import com.sxtools.sxtoolscanal.entity.Canal;
import com.sxtools.sxtoolscanal.service.CanalService;
import com.sxtools.sxtoolscanal.repository.CanalRepository;
import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.service.mapper.CanalMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.service.mapper.CanalMapper.convertEntityToDto;
import static com.sxtools.sxtoolscanal.service.mapper.CanalMapper.convertRequestToEntity;

@Service
public class CanalServiceImpl implements CanalService {

    private final CanalRepository canalRepository;

    @Autowired
    public CanalServiceImpl(CanalRepository canalRepository) {
        this.canalRepository = canalRepository;
    }


    /**
     * @return
     */
    @Override
    public List<CanalResponse> listaCanais() {

        List<Canal> entity = canalRepository.findAll();
        List<CanalResponse> responseList = new ArrayList<>();
        for (Canal canal : entity) {
            responseList.add(convertEntityToDto(canal));
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
        return convertEntityToDto(canal);
    }

    /**
     * @param canalRequest
     * @return
     */
    @Override
    public CanalResponse insereCanal(CanalRequest canalRequest) {
        Canal canal = convertRequestToEntity(canalRequest);
        return convertEntityToDto(canalRepository.save(canal));
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
                    return convertEntityToDto(canalUpdate);
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
