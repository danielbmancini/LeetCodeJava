public class LeetCode392 {

    public static void main(String[] args) { //Is Subsequence
        /*
         * Dadas duas strings s e t, retorna true se s for uma subsequência de t, ou false caso contrário.
        Uma subsequência de uma string é uma nova string que é formada a partir da string original pela exclusão de alguns (pode ser nenhum) caracteres sem perturbar as posições relativas dos caracteres restantes. 
        (por exemplo, "ace" é uma subsequência de "abcde", enquanto "aec" não é).
         */
        LeetCode392 leetCode392 = new LeetCode392();

        System.out.println(leetCode392.isSubsequence("", ""));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;

        int j = 0;
        int max = j;
        char current = s.charAt(0);

        for (char character : s.toCharArray()) {
            if (character == current)
                j++;
            else {
                if (j > max)
                    max = j;
                current = character;
                j = 0;
            }
        }

        if (j > max)
            max = j;
        j = 0;
        int kounter = 0;
        current = s.charAt(0);
        Character lastCharacter = current;
        for (Character character : t.toCharArray()) {
            if (character == current && lastCharacter == character) {
                ++kounter;
                if (kounter > max)
                    continue;
            }

            if (character == s.charAt(j))
                ++j;
            if (j == s.length())
                return true;
        }
        return false;
    }
}
