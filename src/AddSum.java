
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        res.next = null;
        int a =0;
        int b = 0;
        int i = 0;
        int result = 0;
        while (l1 != null){

            a += l1.val*Math.pow(10,i);

            l1 = l1.next;
        }
        i = 0;
        while (l2 != null){

            b += l2.val*Math.pow(10,i);

            l2 = l2.next;
            i++;
        }

        result = a+b;
        i = 1;
        ListNode n = new ListNode(result % (int)Math.pow(10,i));
        result = result/(int)Math.pow(10,i);
        res = n;
        while (result != 0){
            i++;
            ListNode m = new ListNode(result % (int)Math.pow(10,i));
            //System.out.print(result % (int)Math.pow(10,i+1));
            result = result/(int)Math.pow(10,i);
            n.next = m;
            n = n.next;
        }
        return res;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next = l3;
        addTwoNumbers(l1,l2);
    }
}
