
public class InsertionSort {
    public static void sort(int[] values) {
        int sorted = 1;
        while (sorted < values.length) {
            int cur = sorted;
            while (cur > 0 && values[cur] < values[cur-1]) {
                int swap = values[cur - 1];
                values[cur - 1] = values[cur];
                values[cur] = swap;
                --cur;
            }
            ++sorted;
        }
    };
}
