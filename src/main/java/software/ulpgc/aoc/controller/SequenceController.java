package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.SumMatchingNumbersCommand;
import software.ulpgc.aoc.model.NumericInterval;
import software.ulpgc.aoc.model.NumberCriteria;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceController {
    private final NumberCriteria criteria;

    private SequenceController(NumberCriteria criteria) {
        this.criteria = criteria;
    }

    public static SequenceController withStrategy(NumberCriteria criteria) {
        return new SequenceController(criteria);
    }

    public long process(String rawInput) {
        // Creación de objetos Interval
        List<NumericInterval> intervals = Arrays.stream(rawInput.split(","))
                .map(s -> s.trim().replaceAll("\\s+", "")) // Quitar espacios
                .filter(s -> !s.isEmpty())
                .map(this::parseInterval)
                .collect(Collectors.toList()); // Recorre los elementos del Stream y los mete en una lista

        return new SumMatchingNumbersCommand(intervals, criteria).execute();
    }

    private NumericInterval parseInterval(String segment) {
        String[] parts = segment.split("-");
        return new NumericInterval(
                Long.parseLong(parts[0]),
                Long.parseLong(parts[1])
        );
    }
}