package at.rocboron.emailverifier.test;

import at.rocboron.emailverifier.EmailSuggester;
import at.rocboron.emailverifier.EmailValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EmailSuggestorTest {

    EmailSuggester es;

    @Before
    public void init() {
        es = new EmailSuggester();
    }

    @Test
    public void shouldFixDotConIssue1() {
        assertEquals("roc@rocboronat.com", es.getSuggestedEmail("roc@rocboronat.con"));
    }

    @Test
    public void shouldFixDotConIssue2() {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.con"));
    }

    @Test
    public void shouldFixDotConIssue3() {
        assertEquals("a@b.com", es.getSuggestedEmail("a@b.con"));
    }

    @Test
    public void shouldFixGnailIssue() {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.com"));
    }

    @Test
    public void shouldFixGnailAndConIssue() {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.con"));
    }

    @Test
    public void shouldFixGmialIssue() {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.com"));
    }

    @Test
    public void shouldFixGmialAndConIssue() {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.con"));
    }
}
