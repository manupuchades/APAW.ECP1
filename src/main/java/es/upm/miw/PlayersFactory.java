package es.upm.miw;

import org.apache.commons.text.RandomStringGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayersFactory implements IObservable {

    private static final int KEY_LENGTH = 20;

    private static PlayersFactory playersFactory = new PlayersFactory();

    private Map<String, Player> players;

    private ArrayList<IObserver> IObservers;

    private PlayersFactory(){
        this.IObservers = new ArrayList<IObserver>();
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

        notifyObservers();

        return key;
    }

    public Player removePlayer (String key){
        return this.players.remove(key);
    }

    @Override
    public void addObserver(IObserver IObserver) {
        IObservers.add(IObserver);
    }

    @Override
    public void removeObserver(IObserver IObserver) {
        IObservers.remove(IObserver);
    }

    private void notifyObservers() {
        for (IObserver o : IObservers) {
            o.update();
        }
    }
}
