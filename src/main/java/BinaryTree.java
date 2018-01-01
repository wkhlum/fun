import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    public class Item {
        public Item root;
        public Item left;
        public Item right;
        public int value;
        public Item(int t, Item root) {
            value = t;
            this.root = root;
        }
    }
    
    Item root;
    
    public BinaryTree() {
        root = null;
    }
    
    public Item min() {
        Item cur = root;
        while (cur != null) {
            if (cur.left == null) return cur;
            cur = cur.left;
        }
        return null;
    }
    
    public Item max() {
        Item cur = root;
        while (cur != null) {
            if (cur.right == null) return cur;
            cur = cur.right;
        }
        return null;
    }
    
    public Item search(int t) {
        Item cur = root;
        while (cur != null) {
            if (cur.value == t) return cur;
            if (t < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
    
    public void insert(int t) {
        if (root == null) {
            root = new Item(t, null);
            return;
        }
        Item cur = root;
        while (cur != null) {
            if (t < cur.value) {
                if (cur.left == null) {
                    cur.left = new Item(t, cur);
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Item(t, cur);
                    return;
                }
                cur = cur.right;
            }
        }
    }
    
    public void delete(int t) {
        Item item = search(t);
        if (item == null) return;
        if (item.left == null && item.right == null) {
            replace(item, null);
        } else if (item.left == null) {
            replace(item, item.right);
        } else if (item.right == null) {
            replace(item, item.left);
        } else {
            // find next item
            Item next = item.right;
            while (next.left != null) {
                next = next.left;
            }
            item.value = next.value;
            replace(next, next.right);
        }
    }
    
    public void replace(Item from, Item to) {
        if (from.root != null) {
            if (from.root.left == from) {
                from.root.left = to;
            } else {
                from.root.right = to;
            }
        }
    }
    
    public void traverse_dfs() {
        System.out.printf("traverse_dfs: ");
        dfs(root);
        System.out.printf("\n");
    }
    
    public void dfs(Item item) {
        if (item == null) return;
        dfs(item.left);
        System.out.printf("%d ", item.value);
        dfs(item.right);
    }
    
    public void traverse_bfs() {
        System.out.printf("traverse_bfs: ");
        Queue<Item> queue = new LinkedList<Item>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Item cur = queue.remove();
            if (cur.left != null) { 
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            System.out.printf("%d ", cur.value);
        }
        System.out.printf("\n");
    }
}