package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String... args) {
    String input = IO.readln("?> ");

    Pattern p = Pattern.compile("TBD");
    Matcher m = p.matcher(input);

    if (m.find()) IO.println("Match: '" + m.group() + "' [" + m.start() + ", " + m.end() + ")");
  }
}
