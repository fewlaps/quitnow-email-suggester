package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.bean.EmailCorrection;
import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;

import java.util.Arrays;
import java.util.List;

public class EmailSuggester {

    public static final String YAHOO = "yahoo";
    public static final String GMAIL = "gmail";
    public static final String HOTMAIL = "hotmail";
    public static final String OUTLOOK = "outlook";

    public static final String COM = "com";

    public static final String DOTCOM = ".com";
    public static final String DOTNET = ".net";
    public static final String DOTFR = ".fr";

    public List<EmailCorrection> tldCorrections = Arrays.asList(
            new EmailCorrection(".cpm", DOTCOM),
            new EmailCorrection(".cpn", DOTCOM),
            new EmailCorrection(".con", DOTCOM),
            new EmailCorrection(".col", DOTCOM),
            new EmailCorrection(".comm", DOTCOM),
            new EmailCorrection(".cxom", DOTCOM),
            new EmailCorrection(".coml", DOTCOM),
            new EmailCorrection(".clm", DOTCOM),
            new EmailCorrection(".cm", DOTCOM),
            new EmailCorrection(".ney", DOTNET),
            new EmailCorrection(".nte", DOTNET),
            new EmailCorrection(".ft", DOTFR),
            new EmailCorrection(".vom", DOTCOM),
            new EmailCorrection(".fe", DOTFR)
    );

    public List<EmailCorrection> domainCorrections = Arrays.asList(
            new EmailCorrection("gnail", GMAIL),
            new EmailCorrection("gmial", GMAIL),
            new EmailCorrection("gmaail", GMAIL),
            new EmailCorrection("gnail", GMAIL),
            new EmailCorrection("gamil", GMAIL),
            new EmailCorrection("gmal", GMAIL),
            new EmailCorrection("ygmail", GMAIL),
            new EmailCorrection("gmai", GMAIL),
            new EmailCorrection("gimail", GMAIL),
            new EmailCorrection("gmaik", GMAIL),
            new EmailCorrection("gemail", GMAIL),
            new EmailCorrection("gmali", GMAIL),

            new EmailCorrection("hotmaail", HOTMAIL),
            new EmailCorrection("hotmal", HOTMAIL),
            new EmailCorrection("hotmai", HOTMAIL),
            new EmailCorrection("hotmali", HOTMAIL),
            new EmailCorrection("hitmail", HOTMAIL),
            new EmailCorrection("hotmial", HOTMAIL),
            new EmailCorrection("hotmale", HOTMAIL),
            new EmailCorrection("homtail", HOTMAIL),
            new EmailCorrection("hotnail", HOTMAIL),
            new EmailCorrection("hormail", HOTMAIL),
            new EmailCorrection("hotmmail", HOTMAIL),

            new EmailCorrection("yaho", YAHOO),
            new EmailCorrection("yaoo", YAHOO),
            new EmailCorrection("yaboo", YAHOO),
            new EmailCorrection("yahou", YAHOO),
            new EmailCorrection("uahoo", YAHOO),
            new EmailCorrection("yhoo", YAHOO),

            new EmailCorrection("outllok", OUTLOOK),
            new EmailCorrection("outilook", OUTLOOK)
    );

    public List<EmailCorrection> domainAndTldCorrections = Arrays.asList(
            new EmailCorrection("gmail.co", GMAIL + DOTCOM),
            new EmailCorrection("yahoo.om", YAHOO + DOTCOM),
            new EmailCorrection("gmail.om", GMAIL + DOTCOM)
    );

    public String getSuggestedEmail(String email) throws InvalidEmailException {
        if (email == null) {
            throw new InvalidEmailException();
        }

        email = fixComWithAnotherChar(email);
        for (EmailCorrection correction : tldCorrections) {
            email = fixTld(email, correction.getBadEnd(), correction.getGoodEnd());
        }
        for (EmailCorrection correction : domainCorrections) {
            email = fixDomain(email, correction.getBadEnd(), correction.getGoodEnd());
        }
        for (EmailCorrection correction : domainAndTldCorrections) {
            email = fixDomainAndTld(email, correction.getBadEnd(), correction.getGoodEnd());
        }

        return email;
    }

    private String fixComWithAnotherChar(String email) throws InvalidEmailException {
        EmailPartsSplitter ep = new EmailPartsSplitter();
        String tld = ep.getTld(email);
        if (tld.contains(COM) && tld.length() == COM.length() + 1) {//if it's coma, comb, comc, acom, bcom, ccom...
            return fixTld(email, tld, COM);
        } else {
            return email;
        }
    }

    private String fixTld(String email, String badTld, String goodTld) {
        if (email.endsWith(badTld)) {
            email = email.substring(0, email.length() - badTld.length()).concat(goodTld);
        }
        return email;
    }

    private String fixDomain(String email, String badDomain, String goodDomain) throws InvalidEmailException {
        EmailPartsSplitter ep = new EmailPartsSplitter();
        String domain = ep.getDomainWithoutTld(email);
        if (domain.equals(badDomain)) {
            email = email.replaceAll(domain, goodDomain);
        }
        return email;
    }

    private String fixDomainAndTld(String email, String badDomainAndTld, String goodDomainAndTld) {
        if (email.endsWith(badDomainAndTld)) {
            email = email.substring(0, email.length() - badDomainAndTld.length()).concat(goodDomainAndTld);
        }
        return email;
    }
}
