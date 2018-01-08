import java.util.Comparator;

/**
 * Created by helum on 2018-01-04.
 */
public class Edge {
    public int v1;
    public int v2;
    public int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Edge(int v1, int v2) {
        this(v1,v2,0);
    }

    public String toString() {
        return "v1:" + v1 + " v2:" + v2 + " weight:" + weight;
    }
}
