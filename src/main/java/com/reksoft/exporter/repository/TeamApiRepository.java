package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TeamApiRepository implements TeamRepository {
    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    private static final String TEAMS_ENDPOINT = "/api/Teams";

    @Override
    public List<TeamDto> getTeams() {
        String url = apiProperties.getBaseUrl() + TEAMS_ENDPOINT;

        ResponseEntity<List<TeamDto>> response = restTemplate.exchange(
                url,
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }
}
