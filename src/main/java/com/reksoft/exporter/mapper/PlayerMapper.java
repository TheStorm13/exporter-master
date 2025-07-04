package com.reksoft.exporter.mapper;


import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {

    Player toEntity(PlayerViewDto playerViewDto);

    PlayerViewDto toDto(Player player);

}
