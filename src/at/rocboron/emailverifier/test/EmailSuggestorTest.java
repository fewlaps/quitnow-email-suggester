package at.rocboron.emailverifier.test;

import at.rocboron.emailverifier.EmailSuggester;
import at.rocboron.emailverifier.EmailValidator;
import at.rocboron.emailverifier.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EmailSuggestorTest {

    EmailSuggester es;

    @Before
    public void init() {
        es = new EmailSuggester();
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNull() {
        try {
            es.getSuggestedEmail(null);
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForEmpty() {
        try {
            es.getSuggestedEmail("");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForAnInvalidEmail() {
        try {
            es.getSuggestedEmail("roc@roc@roc");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotConIssue1() {
        try {
            assertEquals("roc@rocboronat.com", es.getSuggestedEmail("roc@rocboronat.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotConIssue2() {
        try {
            assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotConIssue3() {
        try {
            assertEquals("a@b.com", es.getSuggestedEmail("a@b.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGnailIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGnailAndConIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmialIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmialAndConIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.con"));
        } catch (Exception e) {
            fail();
        }
    }
}
