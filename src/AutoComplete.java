import java.util.*;
import java.util.regex.Pattern;

public class AutoComplete {
    public static List<Integer> getAutocompleteScores(List<String> documentTitles, List<String> documentBodies, List<String> queries) {
        // Write your code here
        List<Integer> res  = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<>();

        //traversal all docs
        for (int i = 0; i<documentTitles.size() && documentTitles!= null; i++){
            String[] titles = documentTitles.get(i).split(" ");
            for (int j = 0;j <titles.length; j++){
                if (!map.containsKey(titles[j])){
                    map.put(titles[j], 10);
                }else if (map.containsKey(titles[j])){
                    int last = map.get(titles[j]);
                    map.put(titles[j], last + 10);
                }
            }
        }

        for (int k = 0; k< documentBodies.size()&& documentBodies!= null;k++){
            String[] bodies = documentBodies.get(k).split(" ");
            for (int f = 0; f<bodies.length;f++){
                if (!map.containsKey(bodies[f])){
                    map.put(bodies[f], 1);
                }else if (map.containsKey(bodies[f])){
                    int pre = map.get(bodies[f]);
                    map.put(bodies[f],pre + 1);
                }
            }

        }

        Set<String> set = map.keySet();

        //then search for the result
        if (queries== null) return null;
        for (int m = 0; m<queries.size(); m++){
            int num = 0;
            String pattern = queries.get(m) + ".*";
            for (String s: set){
                if ( Pattern.matches(pattern, s)&& map.get(s)>num){
                    num = map.get(s);
                }
            }
            res.add(num);
        }


        return res;
    }

    public static void main(String args[]){
        List<String> doc1 = new ArrayList<String>();
        doc1.add("LET");
        getAutocompleteScores(doc1,doc1,doc1);

    }

}
