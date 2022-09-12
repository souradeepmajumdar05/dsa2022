package linkedlist.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCachefix {
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
    int cap;
    public LRUCachefix(int capacity) {
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
        if(map.get(key)!=null){
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
        if(head==null){
            head=tail;
        }
    }
/**
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 */
    public static void main(String [] args){
        LRUCachefix obj = new LRUCachefix(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }
}
