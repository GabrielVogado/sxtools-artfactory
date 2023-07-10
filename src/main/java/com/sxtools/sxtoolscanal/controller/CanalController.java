package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.document.CanalDocument;
import com.sxtools.sxtoolscanal.iservice.ICanalService;
import com.sxtools.sxtoolscanal.request.CanalRequest;
import com.sxtools.sxtoolscanal.response.CanalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/canal")
public class CanalController implements CanalDocument {

    private final ICanalService canalService;

    @Autowired
    public CanalController(ICanalService canalService) {
        this.canalService = canalService;
    }

    /**
     * @return
     */
    @Override
    @GetMapping("/list-canals")
    public ResponseEntity<List<CanalResponse>> listaCanais() {
        List<CanalResponse> canalResponseList = canalService.listaCanais();
        if(!canalResponseList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.OK).body(canalResponseList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(canalResponseList);
    }

    /**
     * @param id
     * @return
     */
    @Override
    @GetMapping("/getCanalId")
    public ResponseEntity<CanalResponse> getCanalId(@PathVariable Integer id) {

        CanalResponse response = canalService.getCanalId(id);

        if (!ObjectUtils.isEmpty(response)){
            ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    /**
     * @param canalRequest
     * @return
     */
    @Override
    @PostMapping("/insert-canal")
    public ResponseEntity<CanalResponse> insereCanal(@RequestBody CanalRequest canalRequest) {
        CanalResponse response = canalService.insereCanal(canalRequest);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * @param canalRequest
     * @param id
     * @return
     */
    @Override
    @PutMapping("/altera-canal")
    public ResponseEntity<Optional<CanalResponse>> alteraCanal(@RequestBody CanalRequest canalRequest, Integer id) {

        Optional<CanalResponse> response = canalService.alteraCanal(canalRequest,id);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    /**
     * @param id
     */
    @Override
    @DeleteMapping("/delete-canal")
    public void excluirCanal(@PathVariable Integer id) {
        canalService.excluirCanal(id);
    }
}
