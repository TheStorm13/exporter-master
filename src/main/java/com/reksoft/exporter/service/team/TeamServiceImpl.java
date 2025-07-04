package com.reksoft.exporter.service.team;

import com.reksoft.exporter.mapper.TeamMapper;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamApiRepository teamApiRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<Team> getTeams() {
        List<TeamDto> teamDtos = teamApiRepository.getTeams();

        return teamDtos.stream()
                .map(teamMapper::toEntity)
                .toList();
    }
}

