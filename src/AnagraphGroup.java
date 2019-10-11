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
    public static void main(String args[]){
        String[] a = {"eat", "eta","emt","t"};
        groupAnagrams(a);
    }

}
