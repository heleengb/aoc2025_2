package software.ulpgc.aoc.model;

// Devuelve si un numero cumple cierto criterio o no
public interface NumberCriteria {
    boolean satisfies(long value);
}