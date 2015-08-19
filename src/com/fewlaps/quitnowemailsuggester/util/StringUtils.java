package com.fewlaps.quitnowemailsuggester.util;

public class StringUtils {
    public String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }
}
