package software.ulpgc.aoc.model;

import java.util.stream.LongStream;

public record NumericInterval(long start, long end) {
    // Genera un Stream de números para el intervalo
    public LongStream stream() {
        return LongStream.rangeClosed(start, end);
    }
}