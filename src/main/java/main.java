import java.util.Arrays;

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
        
        BTree tree = new BTree();
        System.out.printf("Root - %s\n", tree.root.toString());
        for (int i = 1; i < 11; ++i) {
            tree.insert(i);
        }

        System.out.printf("Root - %s\n", tree.root.toString());
        tree.traverse_bfs();
        tree.resetCounters();
    }
}
