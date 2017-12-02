/**
 * Created by helum on 2017-12-01.
 */
public class CountingSort {
    public static void sort (int [] a, int [] b, int k) {
        int [] c = new int[k+1];
        for (int i = 0; i < c.length; ++i) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; ++i) {
            c[a[i]] = c[a[i]] + 1;
        }
        int cur = 0;
        for (int i = 0; i < c.length; ++i) {
            for(int j = 0; j < c[i]; ++j) {
                b[cur++] = i;
            }
        }
    }
}
