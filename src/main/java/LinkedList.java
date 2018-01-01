public class LinkedList<T> {
    public class Item<T> {
        public Item<T> next;
        public Item<T> prev;
        public T value;
        public Item(T t) {
            value = t;
            next = null;
            prev = null;
        }
        public String toString() {
            String output = value.toString();
            return output;
        }
    }
    
    Item<T> head;
    
    public LinkedList() {
        head = null;
    }
    
    public void insert(T t) {
        Item<T> item = new Item(t);
        if (head == null) {
            head = new Item(null);
            head.next = item;
        } else {
            item.next = head.next;
            head.next.prev = item;
            head.next = item;
        }
    }
    
    // returns position of the first item matched
    public Item search(T t) {
        Item cur = head;
        while (cur != null) {
            if (cur.value != null && cur.value == t) return cur;
            cur = cur.next;
        }
        return null;
    }
    
    public void delete(T t) {
        Item cur = search(t);
        if (cur != null) {
            if (cur.prev == null) {
                // means head
                head.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = null;
                }
                if (head.next == null) {
                    head = null;
                }
            } else {
                cur.prev.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }
            }
        }
    }
}