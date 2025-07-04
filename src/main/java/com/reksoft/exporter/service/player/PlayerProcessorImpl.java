package com.reksoft.exporter.service.player;

import com.reksoft.exporter.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerProcessorImpl implements PlayerProcessor {

    @Override
    public Player addFullName(Player player) {
        String fullName = buildFullName(player.getCombinedName(), player.getNickName());
        player.setFullName(fullName);
        return player;
    }

    private String buildFullName(String combinedName, String nickname) {
        if (combinedName == null) {
            return nickname;
        }

        String[] names = combinedName.split(" ");

        return names[0] + " \"" + nickname + "\" " + names[1];
    }
}
