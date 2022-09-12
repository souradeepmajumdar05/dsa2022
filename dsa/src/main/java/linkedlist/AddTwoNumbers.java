package linkedlist;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.*/
      public class ListNode {
          int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ans=new ListNode(-1);
        ListNode p=ans;
        ListNode p1= l1;
        ListNode p2=l2;
        while(p1!=null ||p2!=null){
            int sum=carry;
            if(p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            if(sum>9){
                carry=1;
                sum=sum-10;
            }else{
                carry=0;
            }

            ListNode temp=new ListNode(sum);
            p.next=temp;
            p=p.next;
        }
        if(carry>0){
            ListNode temp=new ListNode(carry);
            p.next=temp;
        }
        return ans.next;
    }
}
