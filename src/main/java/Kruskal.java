import java.util.ArrayList;
import java.util.List;

/**
 * Created by helum on 2018-01-04.
 */
public class Kruskal {
    String [] vertices;
    List<Edge> edges;

    public Kruskal(String[] vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void minimumSpanningTree() {
        List<Edge> mst = new ArrayList<Edge>();

        DisjointSet[] ds = new DisjointSet[vertices.length];
        for (int i = 0; i < ds.length; ++i) {
            ds[i] = new DisjointSet(i);
        }

        // sort the edges by non-decreasing weight
        edges.sort(new EdgeComparator());

        for (Edge e : edges) {
            if (ds[e.v1].findset() != ds[e.v2].findset()) {
                mst.add(e);
                DisjointSet.union(ds[e.v1], ds[e.v2]);
            }
        }

        System.out.println("Minimum Spanning Tree\n");
        for (Edge e : mst) {
            System.out.printf("Edge: %s\n", e.toString());
        }
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
