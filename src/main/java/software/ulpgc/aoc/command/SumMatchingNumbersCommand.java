package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.NumericInterval;
import software.ulpgc.aoc.model.NumberCriteria;
import java.util.List;

public class SumMatchingNumbersCommand {
    private final List<NumericInterval> intervals;
    private final NumberCriteria criteria;

    public SumMatchingNumbersCommand(List<NumericInterval> intervals, NumberCriteria criteria) {
        this.intervals = intervals;
        this.criteria = criteria;
    }

    public long execute() {
        return intervals.stream()
                .flatMapToLong(NumericInterval::stream) // De intervalo a la lista d nums
                .parallel() // Evalúo en paralelo, en diferentes hilos
                .filter(criteria::satisfies) // metodo reference
                .sum();
    }
}