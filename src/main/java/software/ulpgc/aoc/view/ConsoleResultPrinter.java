package software.ulpgc.aoc.view;

public class ConsoleResultPrinter implements SolutionPrinter {
    @Override
    public void showResult(String title, long value) {
        System.out.println(">>> " + title);
        System.out.println("    Resultado Total: " + value);
        System.out.println("-----------------------------");
    }
}