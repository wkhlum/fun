import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BucketSort {
    public static void sort(double[] values) {
        List<Double>[] buckets = new List[10];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<Double>();
        }
        for (int i = 0; i < values.length; ++i) {
            int j = (int)(values[i] * 10);
            buckets[j].add(values[i]);
        }
        for (int i = 0; i < buckets.length; ++i) {
            Object[] array = (buckets[i]).toArray();
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));
        }
    };
}
