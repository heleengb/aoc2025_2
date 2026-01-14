package software.ulpgc.aoc.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileContentReader implements InputReader {
    private final Path path;

    public FileContentReader(Path path) {
        this.path = path;
    }

    @Override
    public String readContent() throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            // Unimos todas las líneas con comas para procesarlas juntas
            return lines.collect(Collectors.joining(","));
        }
    }
}