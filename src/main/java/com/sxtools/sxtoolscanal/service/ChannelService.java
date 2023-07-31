package com.sxtools.sxtoolscanal.service;

import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;

import java.util.List;
import java.util.Optional;

public interface ChannelService {

    List<ChannelResponse> listaCanais();

    ChannelResponse getCanalId(Integer id);

    DtoResponse insereCanal(ChannelRequest channelRequest);

    Optional<ChannelResponse> alteraCanal(ChannelRequest channelRequest, Integer id);

    void excluirCanal(Integer id);
}
