import java.util.ArrayList;

public class Huffman {
    public class HuffmanNode {
        public char c;
        public int weight;
        public HuffmanNode left;
        public HuffmanNode right;
        public HuffmanNode(char c, int weight) {
            this.c = c;
            this.weight = weight;
            left = null;
            right = null;
        }
        public HuffmanNode(HuffmanNode left, HuffmanNode right) {
            this.left = left;
            this.right = right;
            this.weight = left.weight + right.weight;
        }
        public boolean isLeaf() {
            return left == null && right == null;
        } 
    }
    
    public HuffmanNode compress(char[] chars, int[] weights) {
        if (chars.length != weights.length) {
            System.out.println("array size not equal");
            return null;
        }
        // build nodes
        ArrayList<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
        for (int i = 0; i < chars.length; ++i) {
            HuffmanNode node = new HuffmanNode(chars[i], weights[i]);
            nodes.add(node);
        }
        while (nodes.size() > 1) {
            HuffmanNode left = extractMin(nodes);
            HuffmanNode right = extractMin(nodes);
            HuffmanNode cur = new HuffmanNode(left, right);
            nodes.add(cur);
        }
        return nodes.get(0);
    }
    
    public static void dfs(HuffmanNode item) {
        if (item == null) return;
        dfs(item.left);
        if (item.isLeaf()) {
            System.out.printf("[c(%s),w(%d)]", item.c, item.weight);
        } else {
            System.out.printf("[w(%d)]", item.weight);
        }
        dfs(item.right);
    }
    
    public static HuffmanNode extractMin(ArrayList<HuffmanNode> nodes) {
        HuffmanNode minNode = nodes.get(0);
        for (HuffmanNode node : nodes) {
            if (node.weight < minNode.weight) {
                minNode = node;
            }
        }
        nodes.remove(minNode);
        return minNode;
    }
}