import java.util.Comparator;

/**
 * Created by helum on 2018-01-04.
 */
public class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
