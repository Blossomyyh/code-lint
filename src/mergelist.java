import com.sun.tools.javac.util.List;

import java.util.*;

public class mergelist {
    /**
     * be careful with border cases::
     * [] []
     * [0] []
     * [1] [2]
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = new ListNode(0);
        ListNode p = a;
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        //a.next = l1 == null ? l2 : l1;
        if(l1==null ||l2==null) {
            if(l1==null&&l2==null) return null;
            else if(l1==null && l2!= null) return l2;
            else if(l1!=null && l2== null) return l1;
        }

        while(a!= null && l1!= null &&l2!= null){
            //todo: only two situation:1. <= only one way 2.> the other side
            if(l1.val<=l2.val){
                a.next = l1;
                l1= l1.next;
            } else{
                a.next = l2;
                l2 = l2.next;
            }
            a = a.next;

        }
        //***todo: 1. whether one of them is null 2. add the remain list
        a.next = l1 == null ? l2 : l1;

        return p.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> l = new ArrayList<Integer>();

        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(l);

        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }


    //todo: priority queue
    public ListNode mergeKListsPri(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        };


        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }



    //todo: merge----divide and conquer
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }
    public ListNode mergeListsKDiv(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            System.out.println(lists.length);
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=merge2Lists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }

        return lists[0];
    }

}
