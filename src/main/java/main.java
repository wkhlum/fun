import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");

        /*
        int[] values = new int[] {1};
        System.out.println(Arrays.toString(values));
        QuickSort.sort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
        HeapSort.buildHeap(values);
        for (int heapsize = values.length; heapsize > 1; --heapsize) {
            System.out.printf("max=%d\n", HeapSort.extractMax(values,heapsize));
        }
        values = new int[] {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(values));
        HeapSort.buildHeap(values);
        System.out.println(Arrays.toString(HeapSort.insert(values, 200, values.length)));
        */

/*
        int[] a = {2,5,3,0,2,3,0,3,5,6,7,8,43,5,6,77,6};
        int[] b = new int[a.length];
        System.out.println(Arrays.toString(a));
        RadixSort.sort(a,2);
        System.out.println(Arrays.toString(a));
        */
        /*
        double[] a = { 0.1,0.3,0.66,0.13,0.14,0.11,0.01,0.99,0.45,0.555555};
        BucketSort.sort(a);
        */
        /*
        int[] a = {2,5,3,0,2,3,0,3,5,6,7,8,43,5,77,6};
        MinMax.minmax(a);
        */
        /*
        Queue<Integer> myqueue = new Queue<Integer>();
        System.out.printf("Empty? %d\n", myqueue.isEmpty()?0:1);
        for (int i = 1; i <= 100; ++i) {
            myqueue.enqueue(i);
        }
        for (int i = 1; i <= 120; ++i) {
            if (!myqueue.isEmpty()) {
                System.out.printf("Dequeue=%d\n", myqueue.dequeue());
            }
        }
        */
        /*
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= 100; ++i) {
            list.insert(i);
        }
        for (int i = 1; i <= 120; ++i) {
            LinkedList.Item search = list.search(i);
            System.out.printf("Item:%s\n", search == null ? "null" : search.toString());
            list.delete(i);
        }
        */
        /*
        BinaryTree list = new BinaryTree();
        list.insert(5);
        list.insert(3);
        list.insert(7);
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.insert(9);
        list.insert(1);
        list.insert(8);
        list.insert(10);
        System.out.printf("min=%d,max=%d\n", list.min().value, list.max().value);
        System.out.printf("search(10)=%d,search(3)=%d\n", list.search(10).value, list.search(3).value);
        list.traverse_dfs();
        list.traverse_bfs();
        list.delete(7);
        list.traverse_dfs();
        list.traverse_bfs();
        list.delete(1);
        list.traverse_dfs();
        list.traverse_bfs();
        list.delete(5);
        list.traverse_dfs();
        list.traverse_bfs();
        list.delete(4);
        list.traverse_dfs();
        list.traverse_bfs();
        */
        /*
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};
        for (int i = 1; i < 41; ++i) {
            System.out.printf("CutRod(%d)=%d\n", i, RodCutting.CutRodBottomUp(price,i));
        }
        */
        /*
        Matrix[] input = new Matrix[6];
        input[0] = new Matrix(30,35);
        input[1] = new Matrix(35,15);
        input[2] = new Matrix(15,5);
        input[3] = new Matrix(5,10);
        input[4] = new Matrix(10,20);
        input[5] = new Matrix(20,25);
        MatrixChainOrder order = new MatrixChainOrder(input.length);
        System.out.printf("order=%d, max int=%d\n",order.MinOrder(input,0,5), Integer.MAX_VALUE);
        */
        /*
        GreedyScheduler.Schedule []  schedules = new GreedyScheduler.Schedule[11];
        GreedyScheduler scheduler = new GreedyScheduler();
        schedules[0] = scheduler.new Schedule(1,4);
        schedules[1] = scheduler.new Schedule(3,5);
        schedules[2] = scheduler.new Schedule(0,6);
        schedules[3] = scheduler.new Schedule(5,7);
        schedules[4] = scheduler.new Schedule(3,9);
        schedules[5] = scheduler.new Schedule(5,9);
        schedules[6] = scheduler.new Schedule(6,10);
        schedules[7] = scheduler.new Schedule(8,11);
        schedules[8] = scheduler.new Schedule(8,12);
        schedules[9] = scheduler.new Schedule(2,14);
        schedules[10] = scheduler.new Schedule(12,16);
        GreedyScheduler.schedule(schedules, 1,16);
        */
        /*
        char[] chars = {'a','b','c','d','e','f'};
        int[] weight = {45,13,12,16,9,5};
        Huffman huffman = new Huffman();
        Huffman.HuffmanNode node = huffman.compress(chars, weight);
        Huffman.dfs(node);
        */
        
        /*
        BinaryCounter counter = new BinaryCounter(10);
        System.out.printf("binary counter=%s\n", counter.toString());
        for (int i = 1; i < 1024; ++i) {
            counter.increment();
            System.out.printf("binary counter=%s\n", counter.toString());
        }*/

        /*
        BTree tree = new BTree();
        System.out.printf("Root - %s\n", tree.root.toString());
        for (int i = 1; i < 100; ++i) {
            tree.insert(i);
        }

        System.out.printf("Root - %s\n", tree.root.toString());
        tree.traverse_bfs();
        tree.dfs();
        tree.resetCounters();

        BTree.Node cur = tree.search(77);
        System.out.printf("search(%d) - %s\n", 77, cur == null ? "not found" : cur.toString());

        tree.delete(90);
        tree.traverse_bfs();
        tree.dfs();
        tree.delete(76);
        tree.traverse_bfs();
        tree.dfs();
        */


        FHeap heap = new FHeap();
        for (int i = 1; i <= 10; ++i) {
            heap.insert(i, null);
        }
        for (int i = 1; i <= 10; ++i) {
            System.out.printf("FHeap min=%d\n", heap.extractMin().value);
        }

        /*
        DisjointSet [] sets = new DisjointSet[16];
        for (int i = 0; i < sets.length; ++i) {
            sets[i] = new DisjointSet(i);
            System.out.printf("set[%d] = %s\n", i, sets[i].toString());
        }
        for (int i = 0; i < sets.length - 1; i = i + 2) {
            DisjointSet.union(sets[i], sets[i+1]);
        }

        for (int i = 0; i < sets.length; ++i) {
            System.out.printf("find-set-1[%d] = %s\n", i, sets[i].findset().toString());
        }
        for (int i = 0; i < sets.length - 4; i = i + 4) {
            DisjointSet.union(sets[i], sets[i+2]);
        }
        for (int i = 0; i < sets.length; ++i) {
            System.out.printf("find-set-2[%d] = %s\n", i, sets[i].findset().toString());
        }
        DisjointSet.union(sets[0], sets[4]);
        DisjointSet.union(sets[10], sets[12]);
        DisjointSet.union(sets[0], sets[9]);
        for (int i = 0; i < sets.length; ++i) {
            System.out.printf("find-set-3[%d] = %s\n", i, sets[i].findset().toString());
        }

        DisjointSet set1 = new DisjointSet(1);
        DisjointSet set2 = new DisjointSet(2);
        DisjointSet set3 = new DisjointSet(3);
        DisjointSet set4 = new DisjointSet(4);
        DisjointSet set5 = new DisjointSet(5);
        DisjointSet.union(set1,set2);
        DisjointSet.union(set3,set4);
        DisjointSet.union(set1,set3);
        DisjointSet.union(set5, set1);
        System.out.printf("find-set1= %s\n", set4.findset().toString());
        */

        /*
        String[] items = {"undershorts", "pants", "shoes", "socks", "watch", "belt", "shirt", "tie", "jacket"};
        int[] edge1 = {0,0,3,1,6,6,7,5,1};
        int[] edge2 = {1,2,2,5,5,7,8,8,2};

        Graph graph = new Graph(items, edge1, edge2);
        graph.printGraph();
        graph.sort();
        */

        /*
        String[] vertices = {"a","b","c","d","e","f","g","h","i"};
        List<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,7,8));
        edges.add(new Edge(1,2,8));
        edges.add(new Edge(1,7,11));
        edges.add(new Edge(2,3,7));
        edges.add(new Edge(2,8,2));
        edges.add(new Edge(2,5,4));
        edges.add(new Edge(3,4,9));
        edges.add(new Edge(3,5,14));
        edges.add(new Edge(4,5,10));
        edges.add(new Edge(5,6,2));
        edges.add(new Edge(6,7,1));
        edges.add(new Edge(6,8,6));
        edges.add(new Edge(7,8,7));
        Kruskal k = new Kruskal(vertices, edges);
        Prim p = new Prim(vertices, edges);
        k.minimumSpanningTree();
        p.minimumSpanningTree();
        */
        /*
        String[] vertices = {"s","t","x","y","z"};
        List<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,2,1));
        edges.add(new Edge(1,3,2));
        edges.add(new Edge(2,4,4));
        edges.add(new Edge(3,1,3));
        edges.add(new Edge(3,2,9));
        edges.add(new Edge(3,4,2));
        edges.add(new Edge(4,2,6));
        edges.add(new Edge(4,0,7));
        Dijkstra d = new Dijkstra(vertices, edges);
        d.singleSourceShortestPath(1);

        */
        /*
        Integer[] test = {3,4,5,7,3,7,8,1,3,4,7,8,4,6,8,8,10,43,6,374,345,652,7342,};
        Arrays.sort(test, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Integer[] test2 = new Integer[10];
        System.arraycopy(test, 0, test2, 0, test2.length);
        System.out.println(Arrays.toString(test2));
        */
        String in = " The quick  brown fox    jumped over the fence";
        System.out.println(reverseWords(in));
    }

    public static String reverseWords(String input) {
        String out;
        StringBuffer buffer = new StringBuffer();

        char[] in = input.toCharArray();
        int wend = in.length - 1;

        for (int i = in.length - 1; i >= 0; --i) {
            if (in[i] == ' ') {
                buffer.append(in, i+1, wend - i);
                if (in[wend] != ' ') {
                    buffer.append(in[i]);
                }
                wend = i;
            }
        }
        buffer.append(in, 0, wend);

        out = buffer.toString();
        return out;
    }
}
