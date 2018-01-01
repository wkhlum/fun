import java.util.Queue;
import java.util.LinkedList;

public class BTree {
    public static final int t = 3;
    
    public class Node {
        int[] values;
        Node[] nodes;
        boolean isLeaf;
        int num;
        
        public Node(boolean leaf) {
            isLeaf = leaf;
            values = new int[(2*t) - 1];
            nodes = new Node[(2*t) - 1];
            for (Node n : nodes) {
                n = null;
            }
            num = 0;
        }
        
        public void insertValue(int n) {
            if (num == values.length) return;
            int cur = n;
            int swap;
            for (int i = 0; i < num; ++i) {
                if (cur < values[i]) {
                    swap = values[i];
                    values[i] = cur;
                    cur = swap;
                }
            }
            values[num++] = cur;
        }
        
        public void setChild(Node child, int pos) {
            nodes[pos] = child;
        }
        
        public void insertChild(Node child, int pos) {
            // shift all child nodes from this pos to the right
            for (int i = nodes.length - 1; i > pos; --i) {
                nodes[i] = nodes[i-1];
            }
            nodes[pos] = child;
        }
        
        public String toString() {
            String out = "Node: isLeaf(" + isLeaf + "), num(" + num + "), values=";
            for (int i = 0; i < num; ++i) {
                out += values[i] + ",";
            }
            return out;
        }
    }
    
    public Node root;
    public int pagesRead;
    public int pagesWritten;
    
    public BTree() {
        root = new Node(true);
        resetCounters();
    }
    
    public void resetCounters() {
        System.out.printf("Current counters: read(%d), written(%d)\n", pagesRead, pagesWritten);
        pagesRead = 0;
        pagesWritten = 0;
    }
    
    public void diskRead(Node node) {
        ++pagesRead;
    }
    
    public void diskWritten(Node node) {
        ++pagesWritten;
    }
    
    public void insert(int n) {
        Node cur = root;
        if (cur.num == (2*t) -1 ) {
            Node next = new Node(false);
            next.setChild(cur, 0);
            splitChild(next, 0);
            root = next;
            cur = root;
        }
        insertNonFull(cur, n);
    }
    
    public void splitChild(Node node, int pos) {
        Node split = node.nodes[pos];
        Node left = new Node(split.isLeaf);
        Node right = new Node(split.isLeaf);
        for (int i = 0; i < t-1; ++i) {
            left.insertValue(split.values[i]);
            left.insertChild(split.nodes[i], 0);
        }
        for (int i = t; i < split.num; ++ i) {
            right.insertValue(split.values[i]);
            right.insertChild(split.nodes[i], 0);
        }
        node.setChild(right, pos);
        node.insertChild(left, pos);
        node.insertValue(split.values[t-1]);
        diskRead(split);
        diskWritten(left);
        diskWritten(right);
    }
    
    public void insertNonFull(Node node, int n) {
        if (node.isLeaf) {
            node.insertValue(n);
            return;
        }
        int i = 0;
        while (i < node.num && n < node.values[i]) {
            ++i;
        }
        if (node.nodes[i].num == (2*t) - 1) {
            splitChild(node, i);
        }
        if (n > node.values[i]) {
            ++i;
        }
        insertNonFull(node.nodes[i], n);
    }
    
    public Node search(int n) {
        return null;
    
        
    }
    
    public void traverse_bfs() {
        System.out.println("traverse_bfs");
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            for (Node n : cur.nodes) {
                if (n != null) queue.add(n);
            }
            System.out.println(cur.toString());
        }
    }

}