package es.upm.miw;

import java.time.LocalDateTime;

public class MatchLeaf extends Match implements PlayOff {

    public MatchLeaf(String id, String address, String referee, Team home, Team away, LocalDateTime localTime) {
        super(id, address, referee, home, away, localTime);
    }

    @Override
    public String view() {
        return getId();
    }
}
