import java.util.ArrayList;
import java.util.List;

/**
 * Created by helum on 2018-01-05.
 */
public class Prim {
    String [] vertices;
    List<Edge> edges;

    public Prim(String[] vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void minimumSpanningTree() {
        List<Edge> mst = new ArrayList<Edge>();
        List<Edge> candidates = new ArrayList<Edge>();
        List<Integer> tree = new ArrayList<Integer>();

        for (Edge e : edges) {
            candidates.add(e);
        }
        candidates.sort(new EdgeComparator());

        // start with some vertex and go from there
        tree.add(0);
        while (tree.size() < vertices.length) {
            Edge next = findCheapestEdge(tree, candidates);
            if (next == null) {
                System.out.printf("cannot build MST\n");
                return;
            }
            mst.add(next);
        }

        System.out.printf("Minimum Spanning Tree %s\n", tree.toString());
        for (Edge e : mst) {
            System.out.printf("Edge: %s\n", e.toString());
        }
    }

    public Edge findCheapestEdge(List<Integer> tree, List<Edge> candidates) {
        for (Edge e : candidates) {
            if (tree.contains(e.v1) && !tree.contains(e.v2)) {
                tree.add(e.v2);
                candidates.remove(e);
                return e;
            } else if (tree.contains(e.v2) && !tree.contains(e.v1)) {
                tree.add(e.v1);
                candidates.remove(e);
                return e;
            }
        }
        return null;
    }

    public void printGraph() {
        System.out.printf("Vertices: ");
        for (String v : vertices) {
            System.out.printf("%s,", v);
        }
        System.out.println();
        for (Edge e : edges) {
            System.out.printf("Edge: %s\n", e.toString());
        }
    }
}
