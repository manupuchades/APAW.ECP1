package es.upm.miw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StadiumBuilderTest {

    @Test
    void stadiumBuilderTest() {

        Stadium stadium1 = new Stadium.Builder().named("stadium1").withCapacityFor(1000).isCovered(false).build();
        Stadium stadium2 = new Stadium.Builder().named("stadium2").withCapacityFor(2000).isCovered(true).build();

        assertEquals("stadium1", stadium1.getName());
        assertEquals("stadium2", stadium2.getName());

        assertEquals(1000, stadium1.getCapacity());
        assertEquals(2000, stadium2.getCapacity());

        assertFalse(stadium1.isCovered());
        assertTrue(stadium2.isCovered());
    }
}
