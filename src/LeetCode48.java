import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode48 {
    public static String anagram(String s) {
        char[] sk = s.toCharArray();
        Arrays.sort(sk);
        System.out.println(sk);
        return Arrays.toString(sk);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();

        for(String string : strs){
            String ana = anagram(string);
            if(!anagramMap.containsKey(ana))
                anagramMap.put(ana,new ArrayList<>());

            anagramMap.get(ana).add(string);
        }
        List<List<String>> list = new ArrayList<>();
        anagramMap.forEach((key,value) -> list.add(value));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
