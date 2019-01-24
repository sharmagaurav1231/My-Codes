public class Solution {
 class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public Solution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            setHead(temp);
            return temp.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    public void remove(Node temp) {
        if (temp.pre != null) {
            temp.pre.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        } else {
            end = temp.pre;
        }
    }
    
    public void setHead(Node temp) {
        temp.next = head;
        temp.pre = null;
        if (head != null)
            head.pre = temp;
        head = temp;
        if (end == null)
            end = head;
    }
}