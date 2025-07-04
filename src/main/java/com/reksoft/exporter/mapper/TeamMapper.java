package com.reksoft.exporter.mapper;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    Team toEntity(TeamDto teamDto);

    TeamDto toDto(Team team);
}
