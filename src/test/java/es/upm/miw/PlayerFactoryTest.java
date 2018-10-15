package es.upm.miw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerFactoryTest {

    PlayersFactory players = PlayersFactory.getPlayersFactory();

    String key1;
    String key2;
    String key3;

    @BeforeEach
    void before(){
        key1 = players.addPlayer(new Player("player", 1, Status.STARTER));
        key2 = players.addPlayer(new Player("player", 2, Status.RESERVE));
        key3 = players.addPlayer(new Player("player", 3, Status.INJURED));
    }

    @Test
    void addPlayersTest() {
        assertEquals("player",players.getPlayer(key1).getName());
        assertEquals(1,players.getPlayer(key1).getSquadNumber());

        assertEquals("player",players.getPlayer(key2).getName());
        assertEquals(2,players.getPlayer(key2).getSquadNumber());

        assertEquals("player",players.getPlayer(key3).getName());
        assertEquals(3,players.getPlayer(key3).getSquadNumber());
    }

    @Test
    void removePlayersTest() {
        assertEquals(1,players.removePlayer(key1).getSquadNumber());
        assertNull(players.getPlayer(key1));

        assertEquals(2,players.removePlayer(key2).getSquadNumber());
        assertNull(players.getPlayer(key2));

        assertEquals(3,players.removePlayer(key3).getSquadNumber());
        assertNull(players.getPlayer(key3));
    }
}
