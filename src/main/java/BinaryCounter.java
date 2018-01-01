public class BinaryCounter {
    int[] A;
    
    public BinaryCounter(int length) {
        A = new int[length];
        for ( int i = 0; i < A.length; ++i ) {
            A[i] = 0;
        }
    }
    
    public String toString() {
        String output = "";
        for ( int a = A.length -1; a >= 0; --a ) {
            output += Integer.toString(A[a]);
        }
        return output;
    }
    
    public void increment() {
        for ( int i = 0; i < A.length; ++i) {
            if (A[i] == 0) {
                A[i] = 1;
                return;
            } else {
                A[i] = 0;
            }
        }
    }
}