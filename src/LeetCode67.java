/*
    Add Binary
    Dadas duas strings binárias a e b, retorne sua soma como uma string binária
 */

public class LeetCode67 {
    public String addBinary(String a, String b) {
        String largest = a.length() > b.length() ? a : b;
        String theOtherOne = largest.compareTo(a) == 0 ? b : a;

        theOtherOne = "0".repeat(largest.length() - theOtherOne.length()) + theOtherOne;
        StringBuilder resultReversed = new StringBuilder();
        boolean attach = false;
        for(int i = largest.length() - 1; i >= 0; --i) {
            if(largest.charAt(i) == theOtherOne.charAt(i) && !attach) {
                resultReversed.append("0");
                if(largest.charAt(i) == '1')
                    attach = true;
                continue;
            }
            if(largest.charAt(i) == theOtherOne.charAt(i) && attach) {
                resultReversed.append("1");
                attach = largest.charAt(i) == '1';
                continue;
            }

            if(attach) {
                resultReversed.append("0");
            } else {
                resultReversed.append("1");
            }

        }

        if(attach)
            resultReversed.append("1");

        return resultReversed.reverse().toString();
    }
}
