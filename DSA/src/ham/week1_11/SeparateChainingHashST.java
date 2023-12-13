package ham.week1_11;

import java.util.Objects;

public class SeparateChainingHashST<Key, Value> {
    private int M = 97;               // number of chains
    private Node[] st = new Node[M];  // array of chains

    private static class Node<Key, Value> {
        private Key key;
        private Value val;
        private Node<Key, Value> next;

        public Node(Key key, Value val, Node<Key, Value> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node<Key, Value> x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node<Key, Value> x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
    }
}
