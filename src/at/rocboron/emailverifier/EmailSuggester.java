package at.rocboron.emailverifier;

import at.rocboron.emailverifier.exception.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSuggester {

    public static final String GNAIL_FAIL = "gnail.com";
    public static final String GMIAL_FAIL = "gmial.com";
    public static final String GMAIL_DOTCO_FAIL = "gmail.co";
    public static final String GMAIL = "gmail.com";

    public static final String DOTCPM_FAIL = ".cpm";
    public static final String DOTCPN_FAIL = ".cpn";
    public static final String DOTCON_FAIL = ".con";
    public static final String DOTCOM = ".com";

    public String getSuggestedEmail(String email) throws InvalidEmailException {
        if (email == null) {
            throw new InvalidEmailException();
        }

        //TODO this is a huge violation of Open/Closed principle... it needs to be refactored!
        email = fixDomainByEnd(email, DOTCON_FAIL, DOTCOM);
        email = fixDomainByEnd(email, DOTCPM_FAIL, DOTCOM);
        email = fixDomainByEnd(email, DOTCPN_FAIL, DOTCOM);
        email = fixDomainByEnd(email, GMAIL_DOTCO_FAIL, GMAIL);
        email = fixDomainByEnd(email, GNAIL_FAIL, GMAIL);
        email = fixDomainByEnd(email, GMIAL_FAIL, GMAIL);

        return email;
    }

    private String fixDomainByEnd(String email, String badEnd, String goodEnd) {
        if (email.endsWith(badEnd)) {
            email = email.substring(0, email.length() - badEnd.length()).concat(goodEnd);
        }
        return email;
    }
}
