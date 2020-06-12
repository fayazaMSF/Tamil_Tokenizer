import java.util.Arrays;
import java.util.List;

public class DeTokenizer {
    private static String[] delimit_chars = {".", ",", "\n", " ", "¸", "‚",
            "\"", "/", "-", "|", "\\", "—", "¦",
            "”", "‘", "'", "“", "’", "´", "´",
            "!", "@", "#", "$", "%", "^", "&", "\\*", "+", "\\-", "£", "\\?", "˜",
            "\\(", "\\)", "\\[", "\\]", "{", "}",
            ":", ";",
            "\u2013"};

    private static List<String> del = Arrays.asList(delimit_chars);

    public static void main(String[] args) {
        String line =  "மேற்குறித்த விடயம் தொடர்பாக உங்கள் இலக்கம் மற்றும் 2013.07.01 ஆந் திகதியுடைய கடிதம் தொடர்பாக .";
        System.out.println(detokenize(line));
    }
    public static String detokenize(String text) {
        String[] parts = text.split("\\s+");
        String result = parts[0];

        for(int i = 1 ; i < parts.length ; i++){

            if(!del.contains(parts[i])){
                result = result + " " + parts[i];
            } else {
                result = result + parts[i];
            }
        }

        return result;
    }
}
