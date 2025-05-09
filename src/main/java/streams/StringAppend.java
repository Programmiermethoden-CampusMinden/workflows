package streams;

public class StringAppend {
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
}
