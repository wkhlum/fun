/**
 * Created by helum on 2018-01-04.
 */
public class Graph {


    class Edge {
        public int point;
        public Edge next;
        public Edge (int point) {
            next = null;
            this.point = point;
        }
        public void insert(Edge node) {
            node.next = this.next;
            this.next = node;
        }
    }

    Edge[] edges;
    String[] vertices;
    int num_edges;

    public Graph(String[] vertices, int[] edge1, int[] edge2) {
        this.vertices = vertices;
        edges = new Edge[vertices.length];
        for (int i = 0; i < edge1.length; ++i) {
            Edge edge = new Edge(edge2[i]);
            Edge from = edges[edge1[i]];
            if (from == null) {
                edges[edge1[i]] = edge;
            } else {
                from.insert(edge);
            }
        }
        num_edges = edge1.length;
    }

    public void printGraph() {
        System.out.printf("Graph, num vertices=%d\nVertices:", vertices.length);
        for (String vertex : vertices) {
            System.out.println(vertex);
        }
        System.out.printf("num edges=%d\nEdges:", num_edges);
        for (int i = 0; i < edges.length; ++i) {
            Edge edge = edges[i];
            while (edge != null) {
                System.out.printf("%s->%s\n", vertices[i], vertices[edge.point]);
                edge = edge.next;
            }
        }
    }

    public void sort() {
        Stack<String> orderedItems = new Stack<String>();

        // 0 - not visited
        // 1 - visited
        // 2 - finished
        int[] nodes = new int[vertices.length];
        for (int node : nodes) { node = 0; }
        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == 0) {
                dfs(nodes, i, orderedItems);
            }
        }
        while (!orderedItems.isEmpty()) {
            System.out.printf("Item = %s\n", orderedItems.pop());
        }
    }

    public void dfs(int[] nodes, int node, Stack<String> orderedItems) {
        if (nodes[node] == 2) return;

        // visit this node
        nodes[node] = 1;

        // go to next unvisited node
        Edge edge = edges[node];
        while (edge != null) {
            if (nodes[edge.point] == 0) {
                dfs(nodes, edge.point, orderedItems);
            }
            edge = edge.next;
        }

        // this node is finished
        nodes[node] = 2;
        orderedItems.push(vertices[node]);
    }
}
