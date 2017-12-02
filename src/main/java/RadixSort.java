/**
 * Created by helum on 2017-12-01.
 */
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class RadixSort  {
    public static void sort(int [] v, int digits) {
        for (int i = 1; i <= digits; ++i) {
            innerSort(v, i);
        }
    }

    public static void innerSort(int [] v, int digit) {
        int sorted = 1;
        while (sorted < v.length) {
            int cur = sorted;
            while (cur > 0 && compareDigits(v[cur], v[cur-1], digit)) {
                int swap = v[cur - 1];
                v[cur - 1] = v[cur];
                v[cur] = swap;
                --cur;
            }
            ++sorted;
        }
    }

    public static boolean compareDigits(int t1, int t2, int digit) {
        int d1 = (t1 % (int)Math.pow(10,digit)) / (int)Math.pow(10, (digit-1));
        int d2 = (t2 % (int)Math.pow(10,digit)) / (int)Math.pow(10, (digit-1));
        System.out.printf("compareDigits(%d,%d,%d)=%d,%d\n",t1,t2,digit,d1,d2);
        return d1 < d2;
    }
}
