package wordreversal.assigment_problems;

public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }

            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(reversedWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}
