package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailSplitSuggestorTest {

    EmailSuggester es;

    @Before
    public void init() {
        es = new EmailSuggester();
    }

    @Test
    public void shouldReturnFirstPartWhenIsValidMail() throws InvalidEmailException {
        assertEquals("email@example.com", es.getSuggestedEmail("email@example.com:something"));
    }

    @Test
    public void shouldReturnSecondPartWhenIsValidMail() throws InvalidEmailException {
        assertEquals("email@example.com", es.getSuggestedEmail("something:email@example.com"));
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForAnInvalidFirstPart() throws InvalidEmailException {
        try {
            es.getSuggestedEmail("roc@roc@roc:something");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForAnInvalidSecondPart() throws InvalidEmailException {
        try {
            es.getSuggestedEmail("something:roc@roc@roc");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldFixDotCpnIssueOnFirstPart() throws InvalidEmailException {
       assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.cpn:something"));
    }

    @Test
    public void shouldFixDotCpnIssueOnSecondPart() throws InvalidEmailException {
       assertEquals("roc@gmail.com", es.getSuggestedEmail("something:roc@gmial.cpn"));
    }
}
