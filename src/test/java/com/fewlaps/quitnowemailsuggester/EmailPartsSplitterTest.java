package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EmailPartsSplitterTest {

    EmailPartsSplitter ep;

    @Before
    public void init() {
        ep = new EmailPartsSplitter();
    }

    @Test
    public void shouldReturnCom() throws InvalidEmailException {
        assertEquals("com", ep.getTld("roc@fewlaps.com"));
    }

    @Test
    public void shouldReturnAt() throws InvalidEmailException {
        assertEquals("at", ep.getTld("roc@rocboron.at"));
    }

    @Test
    public void shouldReturnComDotUk() throws InvalidEmailException {
        assertEquals("co.uk", ep.getTld("roc@fewlaps.co.uk"));
    }

    @Test
    public void shouldReturnFewlapsDotCom() throws InvalidEmailException {
        assertEquals("fewlaps.com", ep.getDomain("roc@fewlaps.com"));
    }

    @Test
    public void shouldReturnFewlapsDotCoDotUk() throws InvalidEmailException {
        assertEquals("fewlaps.co.uk", ep.getDomain("roc@fewlaps.co.uk"));
    }

    @Test
    public void shouldReturnFewlaps() throws InvalidEmailException {
        assertEquals("fewlaps", ep.getDomainWithoutTld("roc@fewlaps.co.uk"));
    }

    @Test
    public void shouldReturnRocboron() throws InvalidEmailException {
        assertEquals("rocboron", ep.getDomainWithoutTld("roc@rocboron.at"));
    }

    @Test
    public void shouldReturnGmail() throws InvalidEmailException {
        assertEquals("gmail", ep.getDomainWithoutTld("roc@gmail.com"));
    }

    /**
     * Key test with IT, 'cause "hitmail" contains "it", the TLD
     */
    @Test
    public void shouldReturnHitmail() throws InvalidEmailException {
        assertEquals("hitmail", ep.getDomainWithoutTld("roc@hitmail.it"));
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldLaunchAnInvalidEmailExceptionForNullAtGetTld() throws InvalidEmailException {
        ep.getTld(null);
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldLaunchAnInvalidEmailExceptionForNopeAtGetTld() throws InvalidEmailException {
        ep.getTld("nope");
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldLaunchAnInvalidEmailExceptionForNullAtGetDomain() throws InvalidEmailException {
        ep.getDomain(null);
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldLaunchAnInvalidEmailExceptionForNopeAtGetDomain() throws InvalidEmailException {
        ep.getDomain("nope");
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldLaunchAnInvalidEmailExceptionForNullAtGetDomainWoTld() throws InvalidEmailException {
        ep.getDomainWithoutTld(null);
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldLaunchAnInvalidEmailExceptionForNopeAtGetDomainWoTld() throws InvalidEmailException {
        ep.getDomainWithoutTld("nope");
    }
}
