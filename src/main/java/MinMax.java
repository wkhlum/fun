public class MinMax {
    public static void minmax(int [] v) {
        int min;
        int max;
        if (v.length < 2) {
            System.out.printf("min and max is %d\n", v[0]);
            return;
        }
        if (v[1] > v[0]) {
            min = v[0];
            max = v[1];
        } else {
            min = v[1];
            max = v[0];
        }
        for (int i = 2; i < v.length; i += 2) {
            if (i+1 == v.length) {
                // odd number check
                if (v[i] > max) {
                    max = v[i];
                }
                if (v[i] < min) {
                    min = v[i];
                }
                break;
            }
            if (v[i] > v[i+1]) {
                max = v[i] > max? v[i] : max;
                min = v[i+1] < min? v[i+1] : min;
            } else {
                max = v[i+1] > max? v[i+1] : max;
                min = v[i] < min? v[i] : min;
            }
        }
        System.out.printf("min=%d,max=%d\n", min, max);
    }
}