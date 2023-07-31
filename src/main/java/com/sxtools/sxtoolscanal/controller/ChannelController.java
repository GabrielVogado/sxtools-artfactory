package com.sxtools.sxtoolscanal.controller;

import com.sxtools.sxtoolscanal.config.ChannelDocument;
import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/canal")
public class ChannelController implements ChannelDocument {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    /**
     * @return
     */
    @Override
    @GetMapping("/list-canals")
    public ResponseEntity<List<ChannelResponse>> listaCanais() {
        List<ChannelResponse> channelResponseList = channelService.listaCanais();
        if (!channelResponseList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(channelResponseList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(channelResponseList);
    }

    /**
     * @param id
     * @return
     */
    @Override
    @GetMapping("/getCanalId")
    public ResponseEntity<ChannelResponse> getCanalId(@PathVariable Integer id) {

        ChannelResponse response = channelService.getCanalId(id);

        if (!ObjectUtils.isEmpty(response)) {
            ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    /**
     * @param channelRequest
     * @return
     */
    @Override
    @PostMapping("/insert-canal")
    public ResponseEntity<DtoResponse> insereCanal(@RequestBody ChannelRequest channelRequest) {
        DtoResponse response = channelService.insereCanal(channelRequest);
        if (!ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * @param channelRequest
     * @param id
     * @return
     */
    @Override
    @PutMapping("/altera-canal")
    public ResponseEntity<Optional<ChannelResponse>> alteraCanal(@RequestBody ChannelRequest channelRequest, Integer id) {

        Optional<ChannelResponse> response = channelService.alteraCanal(channelRequest, id);
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
        channelService.excluirCanal(id);
    }
}
