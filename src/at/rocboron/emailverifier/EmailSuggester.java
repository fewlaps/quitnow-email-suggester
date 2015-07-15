package at.rocboron.emailverifier;

import at.rocboron.emailverifier.exception.InvalidEmailException;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSuggester {

    public static final String YAHOO = "yahoo.com";
    public static final String GMAIL = "gmail.com";
    public static final String HOTMAIL = "hotmail.com";

    public static final String DOTCOM = ".com";

    public List<LastWordCorrection> lastWordCorrections = Arrays.asList(
            new LastWordCorrection(".cpm", DOTCOM),
            new LastWordCorrection(".cpn", DOTCOM),
            new LastWordCorrection(".con", DOTCOM),
            new LastWordCorrection(".col", DOTCOM),
            new LastWordCorrection(".comm", DOTCOM),

            new LastWordCorrection("gnail.com", GMAIL),
            new LastWordCorrection("gmial.com", GMAIL),
            new LastWordCorrection("gmaail.com", GMAIL),
            new LastWordCorrection("gnail.com", GMAIL),
            new LastWordCorrection("gamil.com", GMAIL),
            new LastWordCorrection("gmal.com", GMAIL),
            new LastWordCorrection("ygmail.com", GMAIL),

            new LastWordCorrection("hotmaail.com", HOTMAIL),
            new LastWordCorrection("hotmal.com", HOTMAIL),
            new LastWordCorrection("hotmai.com", HOTMAIL),
            new LastWordCorrection("hotmali.com", HOTMAIL),
            new LastWordCorrection("hitmail.com", HOTMAIL),
            new LastWordCorrection("hitmail.it", HOTMAIL),

            new LastWordCorrection("yaho.com", YAHOO),
            new LastWordCorrection("yaboo.com", YAHOO)
    );

    public String getSuggestedEmail(String email) throws InvalidEmailException {
        if (email == null) {
            throw new InvalidEmailException();
        }

        for (LastWordCorrection correction : lastWordCorrections){
            email = fixDomainByEnd(email, correction.getBadEnd(), correction.getGoodEnd());
        }

        return email;
    }

    private String fixDomainByEnd(String email, String badEnd, String goodEnd) {
        if (email.endsWith(badEnd)) {
            email = email.substring(0, email.length() - badEnd.length()).concat(goodEnd);
        }
        return email;
    }
}
