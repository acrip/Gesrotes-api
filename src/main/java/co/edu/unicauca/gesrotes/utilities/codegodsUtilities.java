package co.edu.unicauca.gesrotes.utilities;
import java.text.Normalizer;

public class codegodsUtilities {
    
    public static String plainString(String input) {
        if (input == null) {
            return null;
        }
        String normalizedString = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalizedString.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
