package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;
import java.util.Random;
import java.util.Arrays;

public class BenchmarkRunner {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java BenchmarkRunner <size> <type> <sequence>");
            System.out.println("Example: java BenchmarkRunner 10000 random knuth");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String type = args[1];
        String sequence = args[2];

        Integer[] array = generateArray(size, type);
        PerformanceTracker tracker = new PerformanceTracker();

        System.out.printf("Running ShellSort (%s sequence) on %s array of size %d...\n", sequence, type, size);
        long startTime = System.nanoTime();
        ShellSort.sort(array, sequence, tracker);
        long endTime = System.nanoTime();

        double durationMs = (endTime - startTime) / 1_000_000.0;

        System.out.printf("Time: %.3f ms, Comparisons: %d, Assignments: %d, Swaps: %d%n",
                durationMs, tracker.getComparisons(), tracker.getAssignments(), tracker.getSwaps());

        // Export result to CSV
        saveResult(size, type, sequence, durationMs, tracker);
    }

    private static Integer[] generateArray(int size, String type) {
        Integer[] array = new Integer[size];
        Random rand = new Random();

        switch (type.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < size; i++) array[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < size; i++) array[i] = size - i;
                break;
            default: // random
                for (int i = 0; i < size; i++) array[i] = rand.nextInt(size * 10);
        }
        return array;
    }

    private static void saveResult(int size, String type, String sequence, double timeMs, PerformanceTracker tracker) {
        String csvLine = String.format("%d,%s,%s,%.3f,%d,%d,%d\n",
                size, type, sequence, timeMs,
                tracker.getComparisons(), tracker.getAssignments(), tracker.getSwaps());

        try {
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get("docs/performance"));
            java.nio.file.Path filePath = java.nio.file.Paths.get("docs/performance/results.csv");
            java.nio.file.Files.write(filePath, csvLine.getBytes(),
                    java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.err.println("Error saving CSV: " + e.getMessage());
        }
    }
}
