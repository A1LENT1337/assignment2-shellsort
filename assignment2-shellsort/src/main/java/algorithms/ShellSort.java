package algorithms;

import metrics.PerformanceTracker;
import java.util.Arrays;

public class ShellSort {

    public static <T extends Comparable<T>> void sort(T[] array, String gapSequence, PerformanceTracker tracker) {
        int n = array.length;
        int[] gaps = generateGaps(n, gapSequence);

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                tracker.incrementAssignments();
                int j = i;
                while (j >= gap && array[j - gap].compareTo(temp) > 0) {
                    tracker.incrementComparisons();
                    array[j] = array[j - gap];
                    tracker.incrementAssignments();
                    j -= gap;
                }
                array[j] = temp;
                tracker.incrementAssignments();
            }
        }
    }

    private static int[] generateGaps(int n, String type) {
        switch (type.toLowerCase()) {
            case "knuth":
                return knuthSequence(n);
            case "sedgewick":
                return sedgewickSequence(n);
            default:
                return shellSequence(n);
        }
    }

    private static int[] shellSequence(int n) {
        int gap = n / 2;
        int[] temp = new int[32];
        int count = 0;
        while (gap > 0) {
            temp[count++] = gap;
            gap /= 2;
        }
        return Arrays.copyOf(temp, count);
    }

    private static int[] knuthSequence(int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        int[] temp = new int[32];
        int count = 0;
        while (h >= 1) {
            temp[count++] = h;
            h /= 3;
        }
        return Arrays.copyOf(temp, count);
    }

    private static int[] sedgewickSequence(int n) {
        int[] temp = new int[32];
        int count = 0;
        int k = 0;
        int gap;
        while (true) {
            if (k % 2 == 0)
                gap = 9 * (int) Math.pow(2, k) - 9 * (int) Math.pow(2, k / 2) + 1;
            else
                gap = 8 * (int) Math.pow(2, k) - 6 * (int) Math.pow(2, (k + 1) / 2) + 1;

            if (gap > n)
                break;

            temp[count++] = gap;
            k++;
        }
        int[] seq = new int[count];
        for (int i = 0; i < count; i++) {
            seq[i] = temp[count - 1 - i];
        }
        return seq;
    }
}
