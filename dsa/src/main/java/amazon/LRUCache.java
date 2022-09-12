package amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Node> map = new HashMap<>();
    Node head=null,tail=null;
    int cap=0;
    public LRUCache(int capacity) {
        cap=capacity;
    }

    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }

        Node t=map.get(key);
        remove(t);
        add(t);
        return t.value;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node t=map.get(key);
            t.value=value;
            remove(t);
            add(t);
        }else{
            if(map.size()>=cap){
                map.remove(head.key);
                remove(head);
            }

            Node t=new  Node( key,  value);
            add(t);
            map.put(key,t);
        }
    }
    public void remove(Node n){
        if(n.prev!=null){
            n.prev.next=n.next;
        }
        else{
            head=n.next;
        }
        if(n.next!=null){
            n.next.prev=n.prev;
        }else{
            tail=n.prev;
        }
    }
    public void add(Node n){
        if(tail!=null){
            tail.next=n;
        }
        n.prev=tail;
        n.next=null;
        tail=n;
        System.out.println(n);
        System.out.println(n.key);
        System.out.println(head);
        if(head == null){
            head = tail;
        }
    }

}
