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
}
