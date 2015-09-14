package com.fewlaps.quitnowemailsuggester;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
