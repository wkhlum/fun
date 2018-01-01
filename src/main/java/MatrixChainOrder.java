public class MatrixChainOrder {
    int [][] m;
    //int [][] s;
    
    public MatrixChainOrder(int j) {
        m = new int[j][j];
        //s = new int[j][j];
        for (int i = 0; i < j; ++i) {
            for (int k = 0; k < j; ++k) {
                m[i][k] = Integer.MAX_VALUE;
            }
        }
    }
    
    public int MinOrder(Matrix [] matrices, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int order = Integer.MAX_VALUE;
        if (m[i][j] != Integer.MAX_VALUE) {
            return m[i][j];
        }
        for (int k = i; k < j; ++k) {
            int cur = MinOrder(matrices, i, k) + MinOrder(matrices, k+1, j) + 
                matrices[i].x * matrices[k].y * matrices[j].y;
            if (cur < order) {
                order = cur;
            }
        }
        m[i][j] = order;
        return order;
    }
    
}