// Created by Yuhan Yin on 01/17/2020
/**
 * Definition for singly-linked list.
 */
class Listnode {
     int val;
     Listnode next;
     Listnode(int x) { val = x; }
 }

public class oracle {

    /**
     * NO.1 find middle node
     * singly linked list with root node, return a middle node of linked list.
     * @param root
     * @return frist
     */
    public static Listnode findMiddleNode(Listnode root){

        Listnode first = root;
        Listnode second = root;

        // todo: frist - take one step each / second - take two step each
        // wipe out root is null
        // get the first as middle node when second reach the end
        while (first != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    /**
     * NO.2 find X for ABCD
     * ABCD + X = DCBA ( 1000 ~ 9999 )
     * @param A
     * @param B
     * @param C
     * @param D
     * @return X
     */
    public static int findX(int A, int B, int C, int D){
        int X = 0;



        return X;
    }




}
