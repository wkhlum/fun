import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] v) {
        internal_sort(v, 0, v.length - 1);
    }

    // 0 1 2 3 4
    public static void internal_sort(int[]v, int left, int right) {
        if (left == right) return;
        int middle = (right - left) / 2 + left;
        if (right - left > 1) {
            internal_sort(v, left, middle);
            internal_sort(v, middle + 1, right);
        }
        merge(v, left, middle, right);
    }

    public static void merge(int [] v, int left, int middle, int right ) {
        int [] v1 = Arrays.copyOfRange(v, left, middle + 1);
        int [] v2 = Arrays.copyOfRange(v, middle + 1, right + 1);
        int iV1 = 0;
        int iV2 = 0;
        for (int i = left; i < right + 1; ++i) {
            if (iV1 >= v1.length) {
                v[i] = v2[iV2++];
            } else if (iV2 >= v2.length) {
                v[i] = v1[iV1++];
            } else {
                v[i] = v1[iV1] < v2[iV2] ? v1[iV1++] : v2[iV2++];
            }
        }
    }
}
