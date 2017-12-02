import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");

        /*
        int[] values = new int[] {1};
        System.out.println(Arrays.toString(values));
        QuickSort.sort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
        HeapSort.buildHeap(values);
        for (int heapsize = values.length; heapsize > 1; --heapsize) {
            System.out.printf("max=%d\n", HeapSort.extractMax(values,heapsize));
        }
        values = new int[] {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(values));
        HeapSort.buildHeap(values);
        System.out.println(Arrays.toString(HeapSort.insert(values, 200, values.length)));
        */

        int[] a = {2,5,3,0,2,3,0,3,5,6,7,8,43,5,6,77,6};
        int[] b = new int[a.length];
        System.out.println(Arrays.toString(a));
        RadixSort.sort(a,2);
        System.out.println(Arrays.toString(a));
    }
}
