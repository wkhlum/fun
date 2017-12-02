
public class SelectionSort {
    public static void sort(int [] values) {
        int sorted = 0;
        while (sorted < values.length) {
            int smallest = sorted;
            int cur = sorted + 1;
            while (cur < values.length) {
                if (values[cur] < values[smallest]) {
                    smallest = cur;
                }
                ++cur;
            }
            int swap = values[sorted];
            values[sorted] = values[smallest];
            values[smallest] = swap;
            ++sorted;
        }
    }
}
