package com.maartenmusic.day16;

import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day16Test {

    @Test
    void removeInvalidTickets() {
        File rulesFile = new File("src/test/java/com/maartenmusic/day16/testInputRules.txt");
        List<Rule> rules = TxtFileReaders.toRules(rulesFile);

        File ticketsFile = new File("src/test/java/com/maartenmusic/day16/testInputTickets.txt");
        List<Ticket> tickets = TxtFileReaders.toTickets(ticketsFile);

        assertEquals(3, tickets.size());
        assertTrue(Day16.removeInvalidTickets(tickets, rules)); //test also mutates List
        assertEquals(1, tickets.size());

    }
}