package heap;


import java.util.PriorityQueue;

public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.**/
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(ListNode l:lists){
            while(l!=null)
            {
                pq.add(l.val);
                l=l.next;
            }
        }
        ListNode temp=new ListNode(-1);
        ListNode head=temp;
        while(!pq.isEmpty()){
            head.next=new ListNode(pq.poll());
            head=head.next;
        }
        return temp.next;
    }
    public static void main(String[] args){
     //   ListNode[] temp=new ListNode[];
    }
}
