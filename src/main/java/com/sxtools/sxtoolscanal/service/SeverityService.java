package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;

import java.util.List;
import java.util.Optional;

public interface SeverityService {
    List<SeverityResponse> listaSeverities();

    SeverityResponse getSeverityId(Integer id);

    DtoResponse insereSeverity(SeverityRequest severityRequest);

    Optional<SeverityResponse> alteraSeverity(SeverityRequest severityRequest, Integer id);
}
