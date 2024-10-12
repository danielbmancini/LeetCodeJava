public class LeetCode14 { //Longest Common Prefix
    /*Escreva uma função para encontrar a maior string de prefixo comum entre uma matriz de strings.*/
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int minLength = strs[0].length();
        for (String string : strs)
            if (string.length() < minLength)
                minLength = string.length();


        for (int i = 0; i < minLength; i++) {
            boolean flag = true;
            char candidate = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != candidate) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                stringBuilder.append(candidate);
            else
                break;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abra", "abs", "abraca"}));
    }
}
