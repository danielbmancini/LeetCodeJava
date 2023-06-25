import java.util.Arrays;

/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.*/
public class LeetCode242 {
    public static boolean isAnagram(String s, String t) {
        char[] sk = s.toCharArray();
        char[] tk = t.toCharArray();
        Arrays.sort(sk);
        Arrays.sort(tk);
        return
                Arrays.equals(sk,tk);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ana","ana"));
    }
}
