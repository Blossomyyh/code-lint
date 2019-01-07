public class DesignLinkedList {


    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * 
     * link list -- P-head + P-tail & Hashset
     * 
     * 三个指针-size head tail存于栈stack（无需手动释放）！ node存于堆heap（C++需要手动释放）中
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    private static class ListNode{
//        链表初始化
        int num;
        ListNode next;
        ListNode(int n){
            num = n;
            next = null;
        }
    }

    /** Initialize your data structure here. */

    private ListNode first;
    private ListNode tail;
    private int sum = 0;
    public DesignLinkedList(int n) {

        int sum  = 1;
        first = new ListNode(n);
        first.next = null;
        ListNode tail = first;
    }
    public DesignLinkedList(int n, ListNode _next){
        sum ++;
        first = new ListNode(n);
        first.next = _next;
        tail = first;
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {


//        todo: all index need to be tested for whether in the range!!!!
        if (index< 0 || index > sum) return -1;
        ListNode p = first;
        for (int n = 0; n<index; n++){
            p = p.next;
        }

//        todo: solution 2 -- use index[  while(index--) p = p.next  ]
        return p.num;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode addHead = new ListNode(val);

//        todo: need to verify whether the list is null???
        if (sum++ == 0){
            first = tail = addHead;
        }

        addHead.next = first;
        first = addHead;
        sum++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode addTail = new ListNode(val);

//        todo: need to verify whether the list is null???
        if (sum++ == 0){
            first = tail = addTail;
        }
        addTail.next = null;
        tail.next = addTail;
        sum++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
//        todo: all index need to be tested for whether in the range!!!!
        if (index< 0 || index > sum){
            return;
        } else if (index == 0) addAtHead(val);
          else if (index == sum) addAtTail(val);
          else {
            ListNode addIndex = new ListNode(val);
            ListNode p = first;
            for (int n = 0; n<index; n++){
                p = p.next;
            }
            p.next = addIndex.next;
            p.next = addIndex;
            sum++;
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode p = first;
        for (int n = 0; n<index - 1; n++){
            p = p.next;
        }
        p.next = p.next.next;
        p = p.next;
    }


    /**
     * 判断单链表是否有环
     * 1.两个指针 每走一步另外指针遍历
     * 2.hashset/array 记录每个node的次数
     * 3.2-point: v1 = 1; v2 = 2; 判断是否相交? 即为入环点;指向NULL -----best solution
     *
     * *问题一:判断两个单向链表是否相交，如果相交，求出交点
     *  把两个链表首尾相接，有环的就相交。
     *  相交点就是入环点。
     */

}
