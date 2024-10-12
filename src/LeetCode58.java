public class LeetCode58 { //Length of Last Word
/*Dada uma string s consistindo de palavras e espaços, retorna o comprimento da última palavra na string*/    public static int lengthOfLastWord(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String string = stringBuilder.toString();

        stringBuilder = new StringBuilder();


        for (char character : string.toCharArray()){
            if(character == ' ' && stringBuilder.length() == 0)
                continue;
            else if (character == ' ')
                break;
            stringBuilder.append(character);

        }

        return stringBuilder.length();

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
