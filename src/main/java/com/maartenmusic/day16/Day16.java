package com.maartenmusic.day16;

import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Day16 {
    public static void main(String[] args) {
        System.out.println(getResultPart1());
        System.out.println(getResultPart2());
    }

    public static Long getResultPart2() {
        File rulesFile = new File("src/main/java/com/maartenmusic/day16/inputRules.txt");
        List<Rule> rules = TxtFileReaders.toRules(rulesFile);

        File ticketsFile = new File("src/main/java/com/maartenmusic/day16/inputNearbyTickets.txt");
        List<Ticket> tickets = TxtFileReaders.toTickets(ticketsFile);

        removeInvalidTickets(tickets, rules);

//        if field with index i of each ticket matches a certain rule, that rule is bound to that index.

        Map<Integer, List<Rule>> indexesOfRules = new HashMap<>();

        for (int i = 0; i < 20 ; i++) { // each ticket has 20 fields
            // get all fields at current index
            List<Integer> fieldsAtI = new ArrayList<>();
            int index = i;
            tickets.forEach(ticket -> fieldsAtI.add(ticket.getFields().get(index)));

            // if all fields match a certain rule, save that rule to current index
            for (Rule rule: rules) {
                if (fieldsAtI.stream().allMatch(rule::isValid)) {
                    if (indexesOfRules.containsKey(i)) {
                        indexesOfRules.get(i).add(rule);
                    } else {
                        ArrayList<Rule> matchingRules = new ArrayList<>();
                        matchingRules.add(rule);
                        indexesOfRules.put(i, matchingRules);
                    }
                }
            }
        }

        // find out how rules must be distributed (most rules match more than one list of fields)
        // find value with length of 1, this rule must be tied to this list of fields;
        // add to new map
        // remove that rule from all other values
        // repeat
        Map<Integer, Rule> uniqueRules = new HashMap<>();

        while (indexesOfRules.size() > 0) {
            Rule uniqueRule = new Rule("justForInit", Arrays.asList(new Range(0, 0), new Range(1, 1)));
            int uniqueRuleKey = 0;
            for (Map.Entry<Integer, List<Rule>> mapEntry : indexesOfRules.entrySet()) {
                if (mapEntry.getValue().size() == 1) {
                    uniqueRule = mapEntry.getValue().get(0);
                    uniqueRuleKey = mapEntry.getKey();
                    uniqueRules.put(uniqueRuleKey, uniqueRule);
                }
            }

            indexesOfRules.remove(uniqueRuleKey);

            for (List<Rule> rulesList : indexesOfRules.values()) {
                rulesList.remove(uniqueRule);
            }
        }

        List<Integer> requiredEntries = uniqueRules.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getName().contains("departure"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        File myTicketFile = new File("src/main/java/com/maartenmusic/day16/inputMyTicket.txt");
        Ticket myTicket = TxtFileReaders.toTicket(myTicketFile);

        return requiredEntries.stream()
                .map(i -> myTicket.getFields().get(i))
                .map(i -> (long)i)
                .reduce((a,b) -> a * b)
                .get();
    }

    public static boolean removeInvalidTickets(List<Ticket> tickets, List<Rule> rules) {
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

        return tickets.removeAll(invalidTickets);
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
