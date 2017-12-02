import java.util.Arrays;

/**
 * Created by helum on 2017-11-27.
 */
public class HeapSort {
    public static int parent(int[] v, int i) {
        if (i < 0) return 0;
        return i / 2;
    }

    public static int left(int[] v, int i, int heapsize) {
        if (i * 2 + 1 >= v.length || i * 2 + 1 >= heapsize) return -1; // leaf node
        return i * 2 + 1;
    }

    public static int right(int[] v, int i, int heapsize) {
        if (i * 2 + 2 >= v.length || i * 2 + 2 >= heapsize) return -1; // leaf node
        return i * 2 + 2;
    }

    public static void swap(int[] v, int i, int j) {
        if (i < 0 || i >= v.length) return;
        if (j < 0 || j >= v.length) return;
        if (i == j) return;
        int swap = v[i];
        v[i] = v[j];
        v[j] = swap;
    }

    public static void maxHeapify(int[] v, int i, int heapsize) {
        if (i < 0 || i >= v.length || v.length < heapsize) return;
        int left = left(v, i, heapsize);
        int right = right(v, i, heapsize);
        int largest = i;
        if (left != -1 && v[left] > v[largest] ) {
            largest = left;
        }
        if (right != -1 && v[right] > v[largest]) {
            largest = right;
        }
        if (i != largest) {
            swap(v, i, largest);
            maxHeapify(v, largest, heapsize);
        }
    }

    public static void buildHeap(int[] v) {
        for (int i = v.length /2; i >= 0; --i) {
            maxHeapify(v, i, v.length);
        }
    }

    public static void sort(int[] v) {
        buildHeap(v);
        for (int i = 0; i <= v.length; i++) {
            int heapsize = v.length - i - 1;
            swap(v,0,heapsize);
            maxHeapify(v, 0, heapsize);
        }
    }

    public static int max(int[] v) {
        return v[0];
    }

    public static int extractMax(int[] v, int heapsize) {
        int max = max(v);
        v[0] = v[heapsize - 1];
        maxHeapify(v,0,heapsize - 1);
        return max;
    }

    public static int increaseKey(int[] v, int i, int newValue) {
        if (newValue < i) return newValue;
        if (i >= v.length) return newValue;
        v[i] = newValue;
        int cur = i;
        while (cur > 0) {
            int p = parent(v, cur);
            if (v[p] < newValue) {
                swap(v, cur, p);
                cur = p;
            } else {
                break;
            }
        }
        return newValue;
    }

    public static int[] insert(int[] v, int value, int heapsize) {
        System.out.println(Arrays.toString(v));
        int [] newV = Arrays.copyOf(v,heapsize + 1);
        newV[heapsize] = -99999999;
        System.out.println(Arrays.toString(newV));
        increaseKey(newV, heapsize, value);
        return newV;
    }
}
