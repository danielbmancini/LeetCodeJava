import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
