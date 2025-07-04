package com.reksoft.exporter.service.report;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamCsvReportService {
    private final TeamService teamService;

    public File generateReport(String filePath) throws IOException {
        List<Team> teams = teamService.getTeams();

        File file = new File(filePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            String[] header = {"ID", "TeamName", "Players"};
            writer.writeNext(header);

            for (Team team : teams) {
                String playerNames = team.getPlayers().stream()
                        .map(Player::getCombinedName)  // or use nickName, or combine fields
                        .collect(Collectors.joining(", "));

                String[] line = {
                        String.valueOf(team.getId()),
                        team.getName(),
                        playerNames
                };
                writer.writeNext(line);
            }
        }

        return file;
    }
}
