package test;

import at.rocboron.emailverifier.EmailParts;
import at.rocboron.emailverifier.EmailValidator;
import at.rocboron.emailverifier.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertTrue;

public class EmailPartsTest {

    EmailParts ep;

    @Before
    public void init() {
        ep = new EmailParts();
    }

    @Test
    public void shouldReturnCom() {
        try {
            assertEquals("com", ep.getTld("roc@fewlaps.com"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnAt() {
        try {
            assertEquals("at", ep.getTld("roc@rocboron.at"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnComDotUk() {
        try {
            assertEquals("co.uk", ep.getTld("roc@fewlaps.co.uk"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnFewlapsDotCom() {
        try {
            assertEquals("fewlaps.com", ep.getDomain("roc@fewlaps.com"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnFewlapsDotCoDotUk() {
        try {
            assertEquals("fewlaps.co.uk", ep.getDomain("roc@fewlaps.co.uk"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnFewlaps() {
        try {
            assertEquals("fewlaps", ep.getDomainWithoutTld("roc@fewlaps.co.uk"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnRocboron() {
        try {
            assertEquals("rocboron", ep.getDomainWithoutTld("roc@rocboron.at"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnGmail() {
        try {
            assertEquals("gmail", ep.getDomainWithoutTld("roc@gmail.com"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }

    /**
     * Key test with IT, 'cause "hitmail" contains "it", the TLD
     */
    @Test
    public void shouldReturnHitmail() {
        try {
            assertEquals("hitmail", ep.getDomainWithoutTld("roc@hitmail.it"));
        } catch (InvalidEmailException e) {
            fail();
        }
    }
}
