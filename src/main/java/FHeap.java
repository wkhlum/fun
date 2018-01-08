import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by helum on 2018-01-02.
 */
public class FHeap {
    public class Node {
        public Node child;
        public Node parent;
        public Node next;
        public Node prev;
        boolean mark;
        public int degree;
        public int value;
        public Object object;

        public Node(int key, Object object) {
            child = null;
            parent = null;
            next = this;
            prev = this;
            this.value = key;
            mark = false;
            degree = 0;
            this.object = object;
        }

        public void insertNode(Node node) {
            next.prev = node;
            node.next = next;
            next = node;
            node.prev = this;
        }

        // remove itself from the linked list
        public void unlinkNode() {
            //if (next == this) return;
            prev.next = next;
            next.prev = prev;
            next = this;
            prev = this;
            parent = null;
        }
    }

    public Node root;
    public int n;

    public FHeap() {
        root = null;
        n = 0;
    }

    public Node insert(int n, Object object) {
        Node node = new Node(n, object);
        if (root == null) {
            root = node;
        } else {
            root.insertNode(node);
        }
        if (n < root.value) {
            root = node;
        }
        ++this.n;
        return node;
    }

    public void delete(int n) {
        // TODO
    }

    public Node min() {
        return root;
    }

    public Node extractMin() {
        Node min = root;
        if (min != null) {
            Node cur = root.child;
            List<Node> childlist = new ArrayList<Node>();
            do {
                if (cur != null) {
                    childlist.add(cur);
                    cur = cur.next;
                }
            } while (cur != root.child);
            for (Node x : childlist) {
                x.unlinkNode();
                root.insertNode(x);
            }
            if (root == root.next) {
                root = null;
            } else {
                root = root.next;
                min.unlinkNode();
                consolidate();
            }
            --n;
        }
        return min;
    }

    public void consolidate() {
        Node[] degrees = new Node[n];
        // link roots until only one of each degree is left
        List<Node> rootlist = new ArrayList<Node>();
        Node cur = root;
        do {
            rootlist.add(cur);
            cur = cur.next;
        } while (cur != root);
        for (Node x : rootlist) {
            int d = x.degree;
            while (d < degrees.length && degrees[d] != null) {
                Node y  = degrees[d];
                if (x.value > y.value) {
                    Node swap = x;
                    x = y;
                    y = swap;
                }
                heapLink(x,y);
                degrees[d] = null;
                ++d;
            }
            x.unlinkNode();
            degrees[x.degree] = x;
        }
        root = null;
        for (Node node : degrees) {
            if (node != null) {
                if (root == null) {
                    root = node;
                } else {
                    root.insertNode(node);
                    if (node.value < root.value) {
                        root = node;
                    }
                }
            }
        }
    }

    public void heapLink(Node parent, Node child) {
        parent.unlinkNode();
        child.unlinkNode();
        if (parent.child != null) {
            parent.child.insertNode(child);
        } else {
            parent.child = child;
        }
        child.parent = parent;
        parent.degree++;
        parent.mark = false;
    }

    public static FHeap merge(FHeap h1, FHeap h2) {
        FHeap heap = new FHeap();
        heap.n = h1.n + h2.n;
        if (h1 != null && h1.root != null && h2 != null) {
            h1.root.insertNode(h2.root);
        }
        if (h1.root.value < h2.root.value) {
            heap.root = h1.root;
        } else {
            heap.root = h2.root;
        }
        return heap;
    }

    public void decreaseKey(Node node, int newKey) {
        if (node == null) return;
        if (node.value < newKey) return;

        node.value = newKey;
        Node parent = node.parent;
        if (parent != null && node.value < parent.value) {
            cut(node, parent);
            cascadingCut(parent);
        }
        if (node.value < root.value) {
            root = node;
        }
    }

    public void cut(Node child, Node parent) {
        child.unlinkNode();
        if (parent.child == child) {
            parent.child = null;
        }
        parent.degree--;
        root.insertNode(child);
        child.parent = null;
        child.mark = false;
    }

    public void cascadingCut(Node parent) {
        Node z = parent.parent;
        if (z != null) {
            if (!parent.mark) {
                parent.mark = true;
            } else {
                cut(parent, z);
                cascadingCut(z);
            }
        }
    }
}
