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
            nodes = new Node[2*t];
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

        public boolean contains(int n) {
            for (int value : values) {
                if (value == n) return true;
            }
            return false;
        }

        public void remove(int n) {
            int i = 0;
            while (i < num && values[i] != n) {
                ++i;
            }
            while (i < num - 1) {
                values[i] = values[i + 1];
                ++i;
            }
            --num;
        }

        public Node getChild(int n) {
            for (int i = 0; i < num; ++i) {
                if (n < values[i]) return nodes[i];
            }
            return nodes[num];
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

        public void removeChild(int pos) {
            // shift all child nodes from this pos to the left
            for (int i = pos; i < nodes.length - 1; ++i) {
                nodes[i] = nodes[i+1];
            }
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
            left.setChild(split.nodes[i], i);
        }
        left.setChild(split.nodes[left.num], left.num);
        for (int i = t; i <= split.num; ++ i) {
            if (i < split.num) right.insertValue(split.values[i]);
            right.insertChild(split.nodes[i], i-t);
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
        while (i < node.num && n > node.values[i]) {
            ++i;
        }
        if (node.nodes[i].num == (2*t) - 1) {
            splitChild(node, i);
            if (n > node.values[i]) {
                ++i;
            }
        }
        insertNonFull(node.nodes[i], n);
    }
    
    public Node search(int n) {
        Node cur = root;
        while (cur != null) {
            if (cur.contains(n)) return cur;
            cur = cur.getChild(n);
        }
        return cur;
    }

    public void delete(int n) {
        innerDelete(root, n);
    }

    public void innerDelete(Node node, int n) {
        // case 1
        if (node.isLeaf) {
            node.remove(n);
            return;
        }
        // case 2
        if (node.contains(n)) {
            Node left;
            Node right;
            int i = 0;
            while (i < node.num && node.values[i] != n) {
                ++i;
            }
            left = node.nodes[i];
            right = node.nodes[i+1];
            if (left.num >= t) {
                node.values[i] = left.values[left.num-1];
                innerDelete(left, node.values[i]);
            } else if (right.num >= t) {
                node.values[i] = right.values[right.num-1];
                innerDelete(right, node.values[i]);
            } else {
                Node merged = new Node(left.isLeaf);
                merged.num = left.num + right.num + 1;
                for (int j = 0; j < left.num; ++j) {
                    merged.values[j] = left.values[j];
                    merged.nodes[j] = left.nodes[j];
                }
                merged.nodes[left.num] = left.nodes[left.num];
                merged.values[left.num] = n;
                for (int j = 0; j < right.num; ++j) {
                    merged.values[j + left.num + 1] = right.values[j];
                    merged.nodes[j + left.num + 1] = right.nodes[j];
                }
                merged.nodes[merged.num] = right.nodes[right.num];
                node.remove(n);
                node.removeChild(i);
                node.setChild(merged, i);
                innerDelete(merged, n);
            }
        } else {
            // case 3
            // determine child node
            int i = 0;
            while (i < node.num && node.values[i] < n) {
                ++i;
            }
            innerDelete(node.nodes[i], n);
        }
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

    public void dfs() {
        System.out.println("traverse_dfs");
        inner_dfs(root);
    }

    public void inner_dfs(Node node) {
        if (node == null) return;
        for (int i = 0; i < node.num; ++i) {
            inner_dfs(node.nodes[i]);
            System.out.printf("%d ", node.values[i]);
        }
        inner_dfs(node.nodes[node.num]);
    }
}