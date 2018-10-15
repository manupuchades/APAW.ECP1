package es.upm.miw;

import org.apache.commons.text.RandomStringGenerator;

import java.util.HashMap;
import java.util.Map;

public class PlayersFactory {

    private static final int KEY_LENGTH = 20;

    private static PlayersFactory playersFactory = new PlayersFactory();

    private Map<String, Player> players;

    private PlayersFactory(){
        players = new HashMap<>();
    }

    public static PlayersFactory getPlayersFactory(){
        return playersFactory;
    }

    public Player getPlayer (String key){
        return players.get(key);
    }

    public String addPlayer (Player player){
        // Generates a 20 code point string, using only the letters a-z
        RandomStringGenerator generator = new RandomStringGenerator.Builder().build();
        String key = generator.generate(KEY_LENGTH);

        player.setId(key);
        this.players.put(key,player);

        return key;
    }



    public Player removePlayer (String key){
        return this.players.remove(key);
    }

}
