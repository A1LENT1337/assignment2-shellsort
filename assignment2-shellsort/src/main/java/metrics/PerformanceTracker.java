package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long assignments;
    private long swaps;

    public void reset() {
        comparisons = 0;
        assignments = 0;
        swaps = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementAssignments() {
        assignments++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getAssignments() {
        return assignments;
    }

    public long getSwaps() {
        return swaps;
    }

    @Override
    public String toString() {
        return String.format("Comparisons: %d, Assignments: %d, Swaps: %d",
                comparisons, assignments, swaps);
    }
}
