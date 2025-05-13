package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAppend {

    public static void main(String[] args) {
        //testen
        String[] testString = {"eins", "zwei", "drei"};
        System.out.println(getParameterNamesJson(testString));
        System.out.println("---hubscher---");
        System.out.println(getParameterNamesJsonStream(testString));
        //ausgabe war:

        //["", "", ""]
        //---hubscher---
        //["eins", "zwei", "drei"]

        //welches ist dann aber falsch?
    }

    /**
     * alte uncoole methode.
     *
     * @param parameterNames
     * @return
     */
    public static String getParameterNamesJson(String[] parameterNames) {
        if (parameterNames.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < parameterNames.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("\"").append(escapeJson(parameterNames[i])).append("\"");
        }
        sb.append("]");
        return sb.toString();
    }

    private static String escapeJson(String parameterName) {
        // does something or another ...
        return "";
    }

    /**
     * Updated Methode mit Stream.
     *
     * @param parameterNames
     * @return
     */
    public static String getParameterNamesJsonStream(String[] parameterNames) {
        if (parameterNames.length == 0) {
            return "[]";
        }

        return Stream.of(parameterNames)
                .map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
