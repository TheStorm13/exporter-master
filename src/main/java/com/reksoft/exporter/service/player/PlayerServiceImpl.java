package com.reksoft.exporter.service.player;

import com.reksoft.exporter.mapper.PlayerMapper;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerApiRepository playerApiRepository;
    private final PlayerMapper playerMapper;
    private final PlayerProcessor playerProcessor;

    @Override
    public List<Player> getPlayers() {
        List<PlayerViewDto> playerViewDtos = playerApiRepository.getPlayers();

        return playerViewDtos.stream()
                .map(playerMapper::toEntity)
                .map(playerProcessor::addFullName)
                .toList();
    }
}
