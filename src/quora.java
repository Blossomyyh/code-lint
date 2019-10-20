import java.util.*;

public class quora {

    /**
     * 输入一组 words 和一组 valid letters，判断有多少个 words 是 valid。判断条件是 words

     里的所有 upper and lower letter 必须在 valid letters 里面。如果 word 里面有 special

     character 不用管。注意 valid letter 只有小写，但是 words 里面有大写的也算 valid。比如 words

     = [hEllo##, This^^], valid letter = [h, e, l, 0, t, h, s]; "hello##" 就是 valid，因为 h，e，l，o

     都在 valid letter 里面， “This^^” 不 valid, 因为 i 不在 valid letter 里面


     题目是键盘坏了，只剩下 b 中的字母按键和所有的数字和符号案件能用，同时 shift 键是好

     的，所以可以切换大小写。问 a 中的单词有几个可以用当前坏掉的键盘打出来。
     */

    public static int brokenKey(String s, char[] letter){
        if (letter.length==0 || s.length()==0) return 0;
        int res =0;
        HashSet<Character> set = new HashSet<Character>();
        for (char l : letter){
            set.add(l);
        }

        String[] newList = s.split("\\W");
        for (String i: newList){
            if (i.length()!=0){
                i = i.toLowerCase();
                boolean ext = true;
                for (int j = 0;j<i.length();j++){
                    if (!set.contains(i.charAt(j))){
                        ext = false;
                        break;
                    }
                }
                if (ext) res++;
            }
        }

        return res;
    }

    /**
     * compare 两个 string，只有小写字母。
     * If two strings are close enough.

     Given two rules to define two strings are close enough.

     1. you can swap neighbor char any times. Ex. "abb" -> "bba"

     2. If two strings have the same character, then you can change the character into

     another.

     Ex. If both strings contain "a" and "b", you can change all "a"s in the first string or

     change all "b"s in the first string. same as the second string

     Ex.

     Input: S1 = "babzccc", S2 = "abbzczz"

     Output: True
     * @param
     */
    public static boolean compFreq (String a, String b){
        if (a.length() != b.length() || a.length() == 0) return false;
        boolean res = true;
        a = a.toLowerCase();
        b = b.toLowerCase();
        HashMap<Character,Integer> st1 = new HashMap<>();
        HashMap<Character,Integer> st2 = new HashMap<>();
        List<Integer> ma = new ArrayList<Integer>();
        List<Integer> mb = new ArrayList<Integer>();
        for (int i = 0; i<a.length();i++){
            st1.put(a.charAt(i), st1.getOrDefault(a.charAt(i),0)+1);
            st2.put(a.charAt(i), st2.getOrDefault(a.charAt(i), 0)+1);
        }

        if (!st1.keySet().equals(st2.keySet()))
            res = false;
        for (char h: st1.keySet()){
            ma.add(st1.get(h));
        }
        // todo: keyset is sorted one!!!   values() only return object!-use get()
        for (char h: st2.keySet()){
            mb.add(st2.get(h));
        }
        if (!ma.equals(mb))
            res = false;
        //System.out.print(st1.values());


        return res;
    }


    boolean replaceSameFrequency(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> mapA = new HashMap();
        HashMap<Character, Integer> mapB = new HashMap();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        List<Integer> listA = new ArrayList();
        List<Integer> listB = new ArrayList();

        HashSet<Character> ha = new HashSet();
        HashSet<Character> hb = new HashSet();

        for (int i = 0; i < aChar.length; i++) {
            mapA.put(aChar[i], mapA.getOrDefault(aChar, 0) + 1);
            ha.add(aChar[i]);
            mapB.put(bChar[i], mapB.getOrDefault(bChar, 0) + 1);
            hb.add(bChar[i]);
        }
        if (!ha.equals(hb))
            return false;

        for (char ma : mapA.keySet()) {
            listA.add(mapA.get(ma));
        }
        for (char mb : mapB.keySet()) {
            listB.add(mapB.get(mb));
        }
        if (listA.equals(listB))
            return true;
        return false;
    }

    /**
     * Input:

     a = [1, 2, 3]

     b = [3, 4]

     query = [[1, 5], [1, 1 , 1], [1, 5]]

     Output:

     [2, 1]
     * @param arg
     */





    public static void main(String arg[]){
        String s = "@%Hello, my# -+dear$ friend!!*()";
        //String[] m = s.split("\\W");
        //s = "HelloMy@#$%".toLowerCase();
        char[] b = {'h', 'e', 'l', 'o', 'm'};
        //brokenKey(s,b);
        compFreq("babzccc", "abbzczz");

    }
}
