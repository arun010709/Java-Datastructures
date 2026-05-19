package interview;

public class CustomHashMap<K, V> {
    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    //array of nodes-buckets
    private Node<K, V>[] buckets;
    //map capacity
    private int capacity = 16;

    public CustomHashMap() {
        buckets = new Node[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> head = buckets[index];
        //Case 1 - If no node present
        if (head == null) {
            buckets[index] = new Node<>(key, value);
            return;
        }

        Node<K, V> current = head;
        //Case 2- When data is present
        while (current != null) {
            //if same key replace just value
            if (current.key == key || (current.key != null && current.key.equals(key))) {
                current.value = value;
                return;
            }

            //if last node break out of loop
            if (current.next == null) {
                break;
            }

            //move pointer to next node
            current=current.next;
        }

        //Chain to the next of current node
        current.next=new Node<>(key, value);

    }

    public V remove(K key) {
        int index = getIndex(key);

        Node<K, V> head = buckets[index];

        if (head == null) {
            return null;
        }

        Node<K,V> current=head;
        Node<K,V> prev=null;

        while (current!=null){
            if(current.key==key || (current.key!=null && current.key.equals(key))){
                //1st node then remove and append current as 2nd node
                if(prev==null){
                    buckets[index]=current.next;
                }
                //middle or next node
                else {
                    prev.next=current.next;
                }

                return current.value;
            }

            prev=current;//move previous to current
            current=current.next;//current is next pointer
        }

        return null;
    }


}
