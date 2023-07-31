package com.sxtools.sxtoolscanal.service.impl;

import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Channel;
import com.sxtools.sxtoolscanal.repository.ChannelRepository;
import com.sxtools.sxtoolscanal.service.ChannelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sxtools.sxtoolscanal.service.mapper.ChannelMapper.*;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }


    /**
     * @return
     */
    @Override
    public List<ChannelResponse> listaCanais() {

        List<Channel> entity = channelRepository.findAll();
        List<ChannelResponse> responseList = new ArrayList<>();
        for (Channel channel : entity) {
            responseList.add(convertEntityToDto(channel));
        }
        return responseList;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ChannelResponse getCanalId(Integer id) {
        Channel channel = channelRepository.getReferenceById(id);
        return convertEntityToDto(channel);
    }

    /**
     * @param channelRequest
     * @return
     */
    @Override
    public DtoResponse insereCanal(ChannelRequest channelRequest) {
        Channel channel = convertRequestToEntity(channelRequest);
        var response = channelRepository.save(channel);

        return convertEntityToDtoResponse(response);
    }

    /**
     * @param channelRequest
     * @return
     */
    @Override
    public Optional<ChannelResponse> alteraCanal(ChannelRequest channelRequest, Integer id) {
        return channelRepository.findById(id).map(
                canal -> {
                    BeanUtils.copyProperties(channelRequest, canal, "id");
                    Channel channelUpdate = channelRepository.save(canal);
                    return convertEntityToDto(channelUpdate);
                }
        );
    }

    /**
     *
     */
    @Override
    public void excluirCanal(Integer id) {
        channelRepository.deleteById(id);
    }
}
