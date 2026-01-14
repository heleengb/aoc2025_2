package software.ulpgc.aoc.model;

// Para parte 1: Mitades iguales
public class HalfRepetitionCriteria implements NumberCriteria {
    @Override
    public boolean satisfies(long value) {
        String s = String.valueOf(value);
        int len = s.length();

        if (len % 2 != 0) return false;

        String firstHalf = s.substring(0, len / 2);
        String secondHalf = s.substring(len / 2);

        return firstHalf.equals(secondHalf);
    }
}