package com.fewlaps.quitnowemailsuggester;

public class StringValidator {
    /**
     * Only contains numbers
     */
    public boolean isNumeric(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    /**
     * Only contains numers and letters
     * Thanks @Jacob! http://stackoverflow.com/questions/12831719/fastest-way-to-check-a-string-is-alphanumeric-in-java
     */
    public boolean isAlphanumeric(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
                return false;
        }
        return true;
    }

    /**
     * Contain a number
     */
    public boolean hasNumber(String text) {
        boolean containsDigit = false;

        if (text != null && !text.isEmpty()) {
            for (char c : text.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }
}
