package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShellSortTest {

    @Test
    void testEmptyArray() {
        Integer[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.sort(arr, "shell", tracker);
        assertArrayEquals(new Integer[]{}, arr);
    }

    @Test
    void testSingleElement() {
        Integer[] arr = {5};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.sort(arr, "knuth", tracker);
        assertArrayEquals(new Integer[]{5}, arr);
    }

    @Test
    void testSortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.sort(arr, "sedgewick", tracker);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        Integer[] arr = {5, 4, 3, 2, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.sort(arr, "shell", tracker);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testDuplicatesArray() {
        Integer[] arr = {3, 1, 2, 3, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.sort(arr, "knuth", tracker);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    void testRandomArray() {
        Integer[] arr = {9, 2, 7, 4, 1, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.sort(arr, "sedgewick", tracker);
        assertArrayEquals(new Integer[]{1, 2, 4, 5, 7, 9}, arr);
    }
}
