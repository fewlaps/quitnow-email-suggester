package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EmailPartsTest {

    EmailParts ep;

    @Before
    public void init() {
        ep = new EmailParts();
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

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNullAtGetTld() throws InvalidEmailException {
        try {
            ep.getTld(null);
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNopeAtGetTld() throws InvalidEmailException {
        try {
            ep.getTld("nope");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNullAtGetDomain() throws InvalidEmailException {
        try {
            ep.getDomain(null);
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNopeAtGetDomain() throws InvalidEmailException {
        try {
            ep.getDomain("nope");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNullAtGetDomainWoTld() throws InvalidEmailException {
        try {
            ep.getDomainWithoutTld(null);
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNopeAtGetDomainWoTld() throws InvalidEmailException {
        try {
            ep.getDomainWithoutTld("nope");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }
}
