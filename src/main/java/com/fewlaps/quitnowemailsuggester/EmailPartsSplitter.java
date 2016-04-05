package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import com.fewlaps.quitnowemailsuggester.util.StringUtils;

public class EmailPartsSplitter {

    EmailValidator ev = new EmailValidator();

    public String getTld(String email) throws InvalidEmailException {
        if (email == null || !ev.hasGoodSyntax(email)) {
            throw new InvalidEmailException();
        }

        String[] domainNameParts = getDomain(email).split("\\.");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= domainNameParts.length - 1; i++) {
            sb.append(".").append(domainNameParts[i]);
        }
        sb.replace(0, 1, "");
        return sb.toString();
    }

    public String getDomain(String email) throws InvalidEmailException {
        if (email == null || !ev.hasGoodSyntax(email)) {
            throw new InvalidEmailException();
        }

        return email.substring(email.indexOf('@') + 1);
    }

    public String getDomainWithoutTld(String email) throws InvalidEmailException {
        if (email == null || !ev.hasGoodSyntax(email)) {
            throw new InvalidEmailException();
        }

        StringUtils stringUtils = new StringUtils();
        return stringUtils.replaceLast(getDomain(email), ".".concat(getTld(email)), "");
    }


}
