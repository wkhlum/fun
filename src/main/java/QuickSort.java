/**
 * Created by helum on 2017-11-29.
 */
public class QuickSort {
    public static void swap(int[] v, int i, int j) {
        if (i < 0 || i >= v.length) return;
        if (j < 0 || j >= v.length) return;
        if (i == j) return;
        int swap = v[i];
        v[i] = v[j];
        v[j] = swap;
    }

    public static int partition(int[]v, int p, int r) {
        if (p < 0 || r < 0 || p >= v.length || r >= v.length || p >= r) return p;
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (v[j] <= v[r]) {
                swap(v, j, ++i);
            }
        }
        swap(v,r, ++i);
        return i;
    }

    public static void sort(int[] v, int p, int r) {
        if (p >= r) return;
        int mid = partition(v, p, r);
        sort(v, p, mid - 1);
        sort(v, mid + 1, r);
    }
}
