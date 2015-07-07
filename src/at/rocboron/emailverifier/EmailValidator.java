package at.rocboron.emailverifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static final String GNAIL_FAIL = "gnail.com";
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
        if (email.endsWith(DOTCON_FAIL)) {
            email = email.substring(0, email.length() - DOTCON_FAIL.length()).concat(DOTCOM);
        }
        if (email.endsWith(GNAIL_FAIL)) {
            email = email.substring(0, email.length() - GNAIL_FAIL.length()).concat(GMAIL);
        }
        return email;
    }
}
