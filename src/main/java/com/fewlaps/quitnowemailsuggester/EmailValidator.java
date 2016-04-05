package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import com.fewlaps.quitnowemailsuggester.repository.Repository;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_PATTERN =
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+";
    private static final String ALIAS_PATTERN = "([^\\s]+(\\+([\\w])*@))";
    private final Pattern emailPattern;
    private final Pattern aliasPattern;
    private Matcher matcher;

    public EmailValidator() {
        emailPattern = Pattern.compile(EMAIL_PATTERN);
        aliasPattern = Pattern.compile(ALIAS_PATTERN);
    }

    public boolean hasGoodSyntax(String email) {
        if (email == null) {
            return false;
        }

        matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean hasValidTld(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidParameterException("The suffix can't be null or blank");
        }

        String suffix = new EmailPartsSplitter().getTld(email);
        List<String> lines = new Repository().getTlds();

        for (String line : lines) {
            if (line.trim().equalsIgnoreCase(suffix)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlias(String email) {
        return hasGoodSyntax(email) && aliasPattern.matcher(email).find();
    }

    public boolean isDisposable(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidParameterException("The email can't be null or blank");
        }

        String domain = new EmailPartsSplitter().getDomain(email);
        String[] disposables = new Repository().getDisposables();

        for (String disposable : disposables) {
            if (disposable.equals(domain)) {
                return true;
            }
        }
        return false;
    }
}
