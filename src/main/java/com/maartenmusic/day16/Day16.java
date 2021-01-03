package com.maartenmusic.day16;

import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Day16 {
    public static void main(String[] args) {
        System.out.println(getResultPart1());
    }

    public static int getResultPart2() {
        File rulesFile = new File("src/main/java/com/maartenmusic/day16/inputRules.txt");
        List<Rule> rules = TxtFileReaders.toRules(rulesFile);

        File ticketsFile = new File("src/main/java/com/maartenmusic/day16/inputNearbyTickets.txt");
        List<Ticket> tickets = TxtFileReaders.toTickets(ticketsFile);
        List<Ticket> invalidTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            for (int field : ticket.getFields()) {
                if (rules.stream().noneMatch(rule -> rule.isValid(field))) {
                    if (!invalidTickets.contains(ticket)) {
                        invalidTickets.add(ticket);
                    }
                }
            }
        }

        tickets.removeAll(invalidTickets);

        return -1;
    }

    public static int getResultPart1() {
        File rulesFile = new File("src/main/java/com/maartenmusic/day16/inputRules.txt");
        List<Rule> rules = TxtFileReaders.toRules(rulesFile);

        File ticketsFile = new File("src/main/java/com/maartenmusic/day16/inputNearbyTickets.txt");
        List<Ticket> tickets = TxtFileReaders.toTickets(ticketsFile);

        List<Integer> invalidFields = new ArrayList<>();

        for (Ticket ticket : tickets) {
            for (int field : ticket.getFields()) {
                if (rules.stream().noneMatch(rule -> rule.isValid(field))) {
                    invalidFields.add(field);
                }
            }
        }

        return invalidFields.stream().reduce(Integer::sum).get();
    }
}
