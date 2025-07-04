package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PlayerApiRepository implements PlayerRepository {

    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    private static final String PLAYERS_ENDPOINT = "/api/Players";
    private static final String FILTERED_PLAYERS_ENDPOINT = "/api/Players/filter";

    public List<PlayerViewDto> getPlayers() {
        String url = apiProperties.getBaseUrl() + PLAYERS_ENDPOINT;

        ResponseEntity<List<PlayerViewDto>> response = restTemplate.exchange(
                url,
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public List<PlayerViewDto> getFilteredPlayers(String filter) {

        String url = UriComponentsBuilder.fromHttpUrl(apiProperties.getBaseUrl() + FILTERED_PLAYERS_ENDPOINT)
                .queryParam("filter", filter)
                .toUriString();

        ResponseEntity<List<PlayerViewDto>> response = restTemplate.exchange(
                url,
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

}
