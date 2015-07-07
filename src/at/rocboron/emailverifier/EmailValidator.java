package at.rocboron.emailverifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static final String GNAIL_FAIL = "gnail.com";
    public static final String GMIAL_FAIL = "gmial.com";
    public static final String GMAIL = "gmail.com";

    public static final String DOTCON_FAIL = ".con";
    public static final String DOTCOM = ".com";

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean isValidEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getSuggestedEmail(String email) {
        email = fixDomainByEnd(email, DOTCON_FAIL, DOTCOM);
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
