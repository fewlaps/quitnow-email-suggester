package test;

import com.fewlaps.quitnowemailsuggester.EmailParts;
import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertTrue;

public class EmailPartsTest {

    EmailParts ep;

    @Before
    public void init() throws InvalidEmailException {
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
}
