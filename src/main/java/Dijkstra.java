import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by helum on 2018-01-05.
 */
public class Dijkstra {
    String [] vertices;
    List<Edge> edges;

    public class Graph {
        int cost;
        int vertex;
        Graph parent;

        public Graph(int vertex) {
            cost = Integer.MAX_VALUE;
            this.vertex = vertex;
            parent = null;
        }
        public String toString() {
            return "vertex=" + vertex + " cost=" + cost + " parent=" + (parent == null ? "null" : parent.vertex);
        }
    }

    public class GraphComparator implements Comparator<Graph> {
        public int compare(Graph o1, Graph o2) {
            return o1.cost - o2.cost;
        }
    }

    public Dijkstra(String[] vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void singleSourceShortestPath(int source) {
        //PriorityQueue<Graph> graph = new PriorityQueue<Graph>(new GraphComparator());
        FHeap heap = new FHeap();
        FHeap.Node[] graphRef = new FHeap.Node[vertices.length];
        List<Graph> paths = new ArrayList<Graph>();

        for (int i = 0; i < vertices.length; ++i) {
            Graph g = new Graph(i);
            if (g.vertex == source) g.cost = 0;
            FHeap.Node node = heap.insert(g.cost, g);
            graphRef[i] = node;
        }

        while (heap.min() != null) {
            //Graph g = graph.poll();
            Graph g = (Graph)heap.extractMin().object;
            for (Edge e: edges) {
                if (e.v1 == g.vertex) {
                    FHeap.Node v2Node = graphRef[e.v2];
                    Graph v2 = (Graph)v2Node.object;
                    if (v2.cost > g.cost + e.weight) {
                        v2.parent = g;
                        v2.cost = g.cost + e.weight;
                        heap.decreaseKey(v2Node, v2.cost);
                        //graph.remove(v2);
                        //graph.add(v2);
                    }
                }
            }
            paths.add(g);
        }

        System.out.printf("single source shortest paths\n");
        for (Graph p : paths) {
            System.out.println(p.toString());
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
