// Created by Yuhan Yin on 01/17/2020

import java.util.Arrays;

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
    public Listnode findMiddleNode(Listnode root){

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
     * (1) first solution
     * merely figure out the value of X
     * ABCD + X = DCBA ( 1000 ~ 9999 )
     * @param A
     * @param B
     * @param C
     * @param D
     * @return X
     */
    public int findX(int A, int B, int C, int D){
        int X = 0;
        if(A>=1 && A<=9 && D>=1 && D<=9 && B>=0 && B<=9 && C>=0 && C<=9){
            X = 999* A + 90* B -90*C- 999*D;
        } else {
            // -1 means has error
            return -1;
        }
        return X;
    }

    /**
     * NO.2 find X for ABCD
     * (2) second solution
     * X can be a reverse operator
     * reverse sequence with stringbuffer
     */
    public static String reverse(int[] num){
        StringBuffer s = new StringBuffer(Arrays.toString(num));
        return s.reverse().toString();
    }



}
