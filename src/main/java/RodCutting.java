public class RodCutting {
    
    public static int CutRod(int[] price, int n) {
        if (n <= 0) return 0;
        int q = -1;
        for (int i = 1; i < price.length && i <= n; ++i) {
            int cur = price[i] + CutRod(price, n - i);
            if (cur > q) {
                q = cur;
            }
        }
        return q;
    }
    
    public static int CutRodTopDown(int [] price, int n) {
        int [] q = new int[n+1];
        for (int i = 0; i < q.length; ++i) {
            q[i] = -1;
        }
        return CutRodTopDownDynamic(price, n, q);
    }
    
    public static int CutRodTopDownDynamic(int [] price, int n, int[] q) {
        if (n <= 0) return 0;
        if (q[n] > 0) return q[n];
        for (int i = 1; i < price.length && i <= n; ++i) {
            int cur = price[i] + CutRodTopDownDynamic(price, n - i, q);
            if (cur > q[n]) {
                q[n] = cur;
            }
        }
        return q[n];
    }
    
    public static int CutRodBottomUp(int [] price, int n) {
        int [] q = new int[n+1];
        int [] s = new int[n+1];
        q[0] = 0;
        s[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int max = -1;
            for (int j = 1; j <= i && j < price.length; ++j) {
                int cur = price[j] + q[i-j];
                if (cur > max) {
                    max = cur;
                    s[i] = j;
                }
            }
            q[i] = max;
        }
        int cur = n;
        System.out.printf("CutRodBottomUp(%d)=%d,cuts=",n,q[n]);
        while (cur > 0) {
            System.out.printf("%d,", s[cur]);
            cur = cur - s[cur];
        }
        return q[n];
    }
}