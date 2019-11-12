import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class calculator {
    public static int basicCalculator(String s){
        int res = 0;
        Stack<Integer> stackVal = new Stack<>();
        Stack<Character> stackOp = new Stack<>();

        int i = 0;
        while (i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int val = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    val = val*10 +(s.charAt(i)-'0');
                    i++;
                }
                stackVal.push(val);
                i--;
            }else if(s.charAt(i)=='-' ||s.charAt(i)=='+'||s.charAt(i)=='('){
                if(!stackOp.isEmpty() && stackOp.peek()=='-' && s.charAt(i)=='+'){
                    char op = stackOp.pop();
                    int val2 = stackVal.pop();
                    int val1 = stackVal.pop();
                    int sum = opcalculate(op, val1, val2);
                    stackVal.push(sum);
                }

                stackOp.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                while (stackOp.peek()!='('){
                    char op = stackOp.pop();
                    int val2 = stackVal.pop();
                    int val1 = stackVal.pop();
                    int sum = opcalculate(op, val1, val2);
                    stackVal.push(sum);
                }
                stackOp.pop();//pop (
            }
            i++;
        }
        while (!stackOp.isEmpty()&& !stackVal.isEmpty()){
            char op = stackOp.pop();
            int val2 = stackVal.pop();
            int val1 = stackVal.pop();
            int sum = opcalculate(op, val1,val2);
            stackVal.push(sum);
        }
        return stackVal.pop();

    }

    public static int opcalculate(char op, int val1, int val2){
        if (op=='-'){
            return val1-val2;
        }else if (op=='+'){
            return val1+val2;
        }else {
            return 0;
        }
    }

    public static int calculate(String s){
        Stack<Object> stack = new Stack<>();
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            System.out.println(c);
            if(c==')'){
                stack.push(c);
            }else if(Character.isDigit(c)){
                int ope = 0;
                int n =0;
                while(i>0 &&Character.isDigit( s.charAt(i))){
                    ope = (int)Math.pow(10,n)*(c-'0') +ope;
                    i--;
                    n++;
                }
                stack.push(ope);
                System.out.println(ope);
            }else if(c!=' '){
                stack.push(c);
            }else if(c=='('){
                int res = 0;
                while(!stack.isEmpty() && (char)stack.peek()-')'!=0){
                    res = (int)stack.pop();
                    if((char)stack.peek()!=')'){
                        char op = (char)stack.pop();
                        if(op=='+'){
                            res += (int)stack.pop();
                        }else if(op=='-'){
                            res-=(int)stack.pop();
                        }
                    }
                }
                System.out.println(res);
                stack.push(res);
            }

        }
        System.out.println(stack.peek());
        return (int)stack.pop();
    }


    public static void main(String args[]){
        /**
         * (a+b)-c
         * Input: "(1+(4+5+2)-3)+(6+8)"
         Output: 23

         // problem!!! "2-4-(8+2-6+(8+4-(1)+8-10))"
         */
//        findLength(new int[]{1,2,3},new int[]{2,3});

        List<List<String>> a = new ArrayList<List<String>>();
//        a.add(new ArrayList<String>())
        ArrayList<String> b = new ArrayList<>();
        b.add("google.com");
        b.add("60");
        a.add(b);
        b.clear();
        b.add("yahoo.google.com");
        b.add("50");
        a.add(b);
//        domain(a);
//        int res = basicCalculator( " 2-1 + 2 ");

//        int res = calculate("(1-2)+4");
//        System.out.print(res);

    }




    public static int calculate2(String s) {
        // append a "+" to allow the for loop later to finish the last execution
        s += "+";
        // list of elements for all basic level operations (+, -)
        List<Integer> sumList = new ArrayList<>();
        // currently traversing number
        String curNum = "";
        // current top level value (*, /)
        int curPhrase = 0;
        // the current number <curNum> needs to be substracted?
        boolean neg = false;
        // the current number <curNum> needs to be mult or div on the curPhrase?
        int op = -1; // 0 -> mult, 1 -> div

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar != ' ') {
                if (curChar == '+' || curChar == '-') {
                    /**
                     - now have a complete curNum
                     - what to perform on curNum -> (+,- OR *,/)
                     - if (+,-), directly put into sumList
                     - if (*,/), end of this phrase
                     - set neg if '-'
                     - reset all other vars
                     */
                    int num = Integer.parseInt(curNum);
                    if (op < 0) {
                        sumList.add(neg ? -num : num);
                    } else {
                        curPhrase = op == 0 ? curPhrase * num : curPhrase / num;
                        sumList.add(curPhrase);
                        op = -1;
                        curPhrase = 0;
                    }
                    curNum = "";
                    neg = curChar == '-';
                } else if (curChar == '*' || curChar == '/') {
                    /**
                     - now have complete curNum
                     - what to perform on curNum -> (+,- OR *,/)
                     - if (+,-), start of this phrase
                     - if (*,/), continue the current phrase
                     - set op accordingly
                     - reset all other vars
                     */
                    int num = Integer.parseInt(curNum);
                    if (op >= 0) {
                        curPhrase = op == 0 ? curPhrase * num : curPhrase / num;
                    } else {
                        curPhrase = neg ? -num : num;
                        neg = false;
                    }
                    curNum = "";
                    op = curChar == '*' ? 0 : 1;
                } else {
                    curNum += curChar;
                }
            }
        }

        // final operations
        int result = 0;
        for (int sum: sumList) {
            result += sum;
        }
        return result;
    }



/**
 * Time: O(n)
 * Space: O(n)
 *
 * intuition:
 * resolve all high level operations on the first traversal (*, /)
 * resolve the rest on the second (+, -)
 * */
}
