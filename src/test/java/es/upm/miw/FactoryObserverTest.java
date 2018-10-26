package es.upm.miw;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FactoryObserverTest {
    PlayersFactory players = PlayersFactory.getPlayersFactory();

    private String nameA;
    private String addressA;
    private List<Player> squadA;

    private String nameR;
    private String addressR;
    private List<Player> squadR;

    private Team teamA;

    private Team teamR;

    private String address;
    private String referee;
    private LocalDateTime localTime;

    private String idM;


    private String createMatch() {

        nameA = "Atletico";
        addressA = "Av. de Luis Aragones, 4, 28022 Madrid";
        squadA = Arrays.asList(new Player("Jan Oblak", 1, Status.STARTER), new Player("Diego Godín", 2, Status.INJURED),
                new Player("Diego Costa", 19, Status.RESERVE));

        nameR = "Real Madrid";
        addressR = "Av. de Concha Espina, 1, 28036 Madrid";
        squadR = Arrays.asList(new Player("Keylor Navas", 1, Status.SUBSTITUTE), new Player("Luka Modrić", 10, Status.STARTER),
                new Player("Gareth Bale", 11, Status.INJURED));

        teamA = new Team(nameA, nameA, addressA, squadA);

        teamR = new Team(nameR, nameR, addressR, squadR);

        address = addressA;
        referee = "Rafael Guerrero";
        localTime = LocalDateTime.now();

        Match match = new Match("match", address, referee, teamA, teamR, localTime);

        players.addObserver(match);

        return idM;
    }

    String key1;
    String key2;
    String key3;

    @BeforeEach
    void before() {
        createMatch();

        key1 = players.addPlayer(new Player("player", 1, Status.STARTER));
        key2 = players.addPlayer(new Player("player", 2, Status.RESERVE));
        key3 = players.addPlayer(new Player("player", 3, Status.INJURED));
    }

    @Test
    void addPlayersTest() {
        assertEquals("player", players.getPlayer(key1).getName());
        assertEquals(1, players.getPlayer(key1).getSquadNumber());

        assertEquals("player", players.getPlayer(key2).getName());
        assertEquals(2, players.getPlayer(key2).getSquadNumber());

        assertEquals("player", players.getPlayer(key3).getName());
        assertEquals(3, players.getPlayer(key3).getSquadNumber());
    }

    @Test
    void removePlayersTest() {
        assertEquals(1, players.removePlayer(key1).getSquadNumber());
        assertNull(players.getPlayer(key1));

        assertEquals(2, players.removePlayer(key2).getSquadNumber());
        assertNull(players.getPlayer(key2));

        assertEquals(3, players.removePlayer(key3).getSquadNumber());
        assertNull(players.getPlayer(key3));
    }
}
