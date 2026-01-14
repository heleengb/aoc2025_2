package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.SequenceController;
import software.ulpgc.aoc.io.FileContentReader;
import software.ulpgc.aoc.model.HalfRepetitionCriteria;
import software.ulpgc.aoc.view.ConsoleResultPrinter;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "rangos.txt");

    public static void main(String[] args) {
        try {
            // IO: Leemos el contenido
            String rawData = new FileContentReader(INPUT_PATH).readContent();

            // Definimos la estrategia
            var strategy = new HalfRepetitionCriteria();

            // Controller: Procesamos
            long start = System.currentTimeMillis();
            long result = SequenceController.withStrategy(strategy).process(rawData);
            long end = System.currentTimeMillis();

            // View
            new ConsoleResultPrinter().showResult("Suma (Mitades Repetidas)", result);
            System.out.println("Tiempo: " + (end - start) + "ms");

        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}