package es.upm.miw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundCompositeTest {

    @Test
    void compositePlayOffTest() {

        Round worldCup = new Round("worldCup");

        String id = "direct";
        String address = "adress";
        String referee = "referree";
        Team home = new Team();
        Team away = new Team();
        LocalDateTime localTime = LocalDateTime.now();

        MatchLeaf partidoDirecto1 = new MatchLeaf(id, address, referee, home, away, localTime);
        MatchLeaf partidoDirecto2 = new MatchLeaf(id, address, referee, home, away, localTime);
        MatchLeaf partidoDirecto3 = new MatchLeaf(id, address, referee, home, away, localTime);

        worldCup.addStage(partidoDirecto1);
        worldCup.addStage(partidoDirecto2);
        worldCup.addStage(partidoDirecto3);

        Round clasifierOceania = new Round("oceania");
        Round clasifierEurope = new Round("europe");

        MatchLeaf partidoClasificatorio1 = new MatchLeaf(id, address, referee, home, away, localTime);
        MatchLeaf partidoClasificatorio2 = new MatchLeaf(id, address, referee, home, away, localTime);
        MatchLeaf partidoClasificatorio3 = new MatchLeaf(id, address, referee, home, away, localTime);

        clasifierOceania.addStage(partidoClasificatorio1);
        clasifierOceania.addStage(partidoClasificatorio2);
        clasifierOceania.addStage(partidoClasificatorio3);

        worldCup.addStage(clasifierOceania);
        worldCup.addStage(clasifierEurope);

        assertEquals("worldCup", worldCup.view());

        assertEquals("direct", worldCup.getRoundMatches().get(0).view());
        assertEquals("oceania", worldCup.getRoundMatches().get(3).view());

    }


}
