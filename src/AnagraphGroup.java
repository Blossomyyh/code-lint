import java.util.*;

public class AnagraphGroup {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            //todo: make String as CharArray and sort it !!
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            // todo: construct new String using char[]
            String key = new String(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());


        //(NKlogK)  Space Complexity:O(NK)
    }


    //Categorize by Count
    public List<List<String>> Anagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;
            //todo: use string builder
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    /**valid anagram
     *
     * @param s
     * @param t
     * @return
     */
    // sort the array time O(Nlogn) space O(n)
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] list1 = s.toCharArray();
        char[] list2 = t.toCharArray();
        Arrays.sort(list1);
        Arrays.sort(list2);
        String m = list1.toString();
        String b = list2.toString();
        // cannot use
        int[] a = {1,2};
        String as =Arrays.toString(a); //todo x.toString can only transfer its address into String
        if(Arrays.toString(list1).equals(Arrays.toString(list2))){
            return true;
        }
        return false;
//        return Arrays.equals(list1,list2);
    }

    // use int[] or map to record ----O(n) O(n)
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char m: s.toCharArray()){
            map.put(m, map.getOrDefault(m,0)+1);
        }
        for(char n: t.toCharArray()){
            if(map.containsKey(n)){
                map.put(n, map.get(n)-1);
                if(map.get(n)==0) map.remove(n);
            }else return false;
        }
        return map.size()==0;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        isAnagram("anana", "nanaa");
        String[] a = {"eat", "eta","emt","t"};
        groupAnagrams(a);
    }

}
