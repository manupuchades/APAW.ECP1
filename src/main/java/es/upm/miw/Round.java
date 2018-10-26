package es.upm.miw;

import java.util.ArrayList;
import java.util.List;

public class Round implements PlayOff {

    private List<PlayOff> roundMatches = new ArrayList<>();

    private String name;

    public Round(String name) {
        this.name = name;
    }

    @Override
    public String view() {
        return name;
    }

    public void addStage(PlayOff stage) {
        roundMatches.add(stage);
    }

    public void removeStage(PlayOff stage) {
        roundMatches.remove(stage);
    }

    public List<PlayOff> getRoundMatches() {
        return roundMatches;
    }
}
