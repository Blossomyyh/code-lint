
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class AddSum {

    /**
     * digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/add-two-numbers
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */

    // units tens hundreds thousands digit is matched from the beginning.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = l1, q = l2, cur = res;
        int carry = 0;
        while(p!= null || q !=null){
            int x = (p==null)? 0:p.val;
            int y = (q ==null)? 0:q.val;
            int sum = carry +x +y;
            carry = sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;

        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return res.next;

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next = l3;
        addTwoNumbers(l1,l2);
    }
}
