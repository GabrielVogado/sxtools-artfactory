package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.config.SeverityDocument;
import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;

import com.sxtools.sxtoolscanal.service.SeverityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/severities")
public class SeverityController implements SeverityDocument {

    private final SeverityService severityService;

    @Autowired
    public SeverityController(SeverityService severityService) {
        this.severityService = severityService;
    }

    /**
     * @return
     */
    @Override
    @GetMapping
    public ResponseEntity<List<SeverityResponse>> listSeverities() {
        List<SeverityResponse> severityResponseList = severityService.listaSeverities();
        if(!severityResponseList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.OK).body(severityResponseList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(severityResponseList);
    }

    /**
     * @param id
     * @return
     */
    @Override
    @GetMapping("/{severity_id}")
    public ResponseEntity<SeverityResponse> getSeverityId(@PathVariable(name = "severity_id") Integer id) {

        SeverityResponse response = severityService.getSeverityId(id);

        if (!ObjectUtils.isEmpty(response)){
            ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    /**
     * @param severityRequest
     * @return
     */
    @Override
    @PostMapping
    public ResponseEntity<SeverityResponse> insereSeverity(@RequestBody SeverityRequest severityRequest) {
        SeverityResponse response = severityService.insereSeverity(severityRequest);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * @param severityRequest
     * @param id
     * @return
     */
    @Override
    @PutMapping("/{severity_id}")
    public ResponseEntity<Optional<SeverityResponse>> alteraSeverity(@RequestBody SeverityRequest severityRequest, @PathVariable(name = "severity_id") Integer id) {

        Optional<SeverityResponse> response = severityService.alteraSeverity(severityRequest,id);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
