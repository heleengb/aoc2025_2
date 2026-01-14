package software.ulpgc.aoc.model;

import java.util.stream.IntStream;

// Para parte 2: Patrón periódico
public class PeriodicSequenceCriteria implements NumberCriteria {
    @Override
    public boolean satisfies(long value) {
        String s = String.valueOf(value);
        int len = s.length();
        if (len < 2) return false;

        // Probamos todos los posibles tamaños de patrón
        return IntStream.rangeClosed(1, len / 2)
                .filter(chunkSize -> len % chunkSize == 0)
                .anyMatch(chunkSize -> isPattern(s, chunkSize));
    }

    private boolean isPattern(String s, int chunkSize) {
        String pattern = s.substring(0, chunkSize);
        // Si reemplazamos el patrón por vacío y no queda nada, es q es periódico
        return s.replace(pattern, "").isEmpty();
    }
}