package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.SequenceController;
import software.ulpgc.aoc.io.FileContentReader;
import software.ulpgc.aoc.model.PeriodicSequenceCriteria;
import software.ulpgc.aoc.view.ConsoleResultPrinter;

import java.io.IOException;
import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "rangos.txt");

    public static void main(String[] args) {
        try {
            // IO
            String rawData = new FileContentReader(INPUT_PATH).readContent();

            // Definimos la estrategia
            var strategy = new PeriodicSequenceCriteria();

            // Controller
            long result = SequenceController.withStrategy(strategy).process(rawData);

            // View
            new ConsoleResultPrinter().showResult("Parte 2 (Números Periódicos)", result);

        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}