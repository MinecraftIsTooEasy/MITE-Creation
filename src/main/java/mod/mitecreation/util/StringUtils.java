package mod.mitecreation.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static int getColor(String colorStr, int defaultColor) {
        Pattern pattern = Pattern.compile("(?:0x|#)([a-fA-F0-9]{1,8})");
        Matcher matcher = pattern.matcher(colorStr);
        if (matcher.matches()) {
            try {
                return (int)Long.parseLong(matcher.group(1), 16);
            } catch (NumberFormatException var5) {
                return defaultColor;
            }
        } else {
            try {
                return Integer.parseInt(colorStr, 10);
            } catch (NumberFormatException var6) {
                return defaultColor;
            }
        }
    }
}
