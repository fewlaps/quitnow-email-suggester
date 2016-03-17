package com.fewlaps.quitnowemailsuggester.util;

public class StringUtils {

    public static final String DEFAULT_SEPARATOR = ":";

    public String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

    public String[] getParts(String string) {
        return getParts(string, DEFAULT_SEPARATOR);
    }

    public String[] getParts(String string, String separator) {
        if (string == null) {
            return null;
        }
        if (string.isEmpty()) {
            return new String[]{};
        }
        if (separator == null || separator.isEmpty()) {
            separator = DEFAULT_SEPARATOR;
        }
        return string.split(separator);
    }
}
