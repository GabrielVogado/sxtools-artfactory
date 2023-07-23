package com.sxtools.sxtoolscanal.service.impl;

import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.entity.Canal;
import com.sxtools.sxtoolscanal.entity.Severity;
import com.sxtools.sxtoolscanal.repository.SeverityRepository;
import com.sxtools.sxtoolscanal.service.SeverityService;
import com.sxtools.sxtoolscanal.service.mapper.CanalMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.service.mapper.SeverityMapper.convertEntityToDto;
import static com.sxtools.sxtoolscanal.service.mapper.SeverityMapper.convertRequestToEntity;


@Service
public class SeverityServiceImpl implements SeverityService {

    private final SeverityRepository severityRepository;

    @Autowired
    public SeverityServiceImpl(SeverityRepository severityRepository) {
        this.severityRepository = severityRepository;
    }


    /**
     * @return
     */
    @Override
    public List<SeverityResponse> listaSeverities() {
        List<Severity> entity = severityRepository.findAll();
        List<SeverityResponse> responseList = new ArrayList<>();
        for (Severity severity : entity) {
            responseList.add(convertEntityToDto(severity));
        }
        return responseList;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SeverityResponse getSeverityId(Integer id) {
        Severity severity = severityRepository.getReferenceById(id);
        return convertEntityToDto(severity);
    }

    /**
     * @param severityRequest
     * @return
     */
    @Override
    public SeverityResponse insereSeverity(SeverityRequest severityRequest) {
        Severity severity = convertRequestToEntity(severityRequest);
        return convertEntityToDto(severityRepository.save(severity));
    }

    /**
     * @param severityRequest
     * @param id
     * @return
     */
    @Override
    public Optional<SeverityResponse> alteraSeverity(SeverityRequest severityRequest, Integer id) {
        return severityRepository.findById(id).map(
                severity -> {
                    BeanUtils.copyProperties(severityRequest, severity, "id");
                    Severity severityUpdate = severityRepository.save(severity);
                    return convertEntityToDto(severityUpdate);
                }
        );
    }
}
