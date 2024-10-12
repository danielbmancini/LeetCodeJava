public class LeetCode28 { //Find the Index of the First Occurrence in a String

    /*Dadas duas strings agulha e palheiro, retorna o índice da primeira ocorrência de agulha em palheiro, ou -1 se agulha não fizer parte de palheiro.     */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            StringBuilder thisTry = new StringBuilder();
            int index = 0;
            for (int j = i; j < needle.length() + i ; j++) {
                if (index + i >= haystack.length())
                    return -1;
                thisTry.append(haystack.charAt(index + i));
                if(needle.charAt(index) == thisTry.charAt(index) && thisTry.length() == needle.length())
                    return i;

                System.out.println(thisTry);

                if (needle.charAt(index) != thisTry.charAt(index++))
                    break;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaa","aaaa"));
    }
}
