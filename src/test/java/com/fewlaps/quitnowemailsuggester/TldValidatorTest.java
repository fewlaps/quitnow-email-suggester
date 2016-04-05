package com.fewlaps.quitnowemailsuggester;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidParameterException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TldValidatorTest {

    TldValidator tldValidator;

    @Before
    public void init() {
        tldValidator = new TldValidator();
    }

    @Test
    public void checkValidTld01() throws IOException {
        assertTrue(tldValidator.isValidTld("co.uk"));
    }

    @Test
    public void checkValidTld02() throws IOException {
        assertTrue(tldValidator.isValidTld("com"));
    }

    @Test
    public void checkValidTldBarcelona() throws IOException {
        assertTrue(tldValidator.isValidTld("barcelona"));
    }

    @Test
    public void shouldReturnFalse_forInvalidCon() throws IOException {
        assertFalse(tldValidator.isValidTld("con"));
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldLaunchAnInvalidParameterException_forBlank() throws IOException {
        tldValidator.isValidTld("");
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldLaunchAnInvalidParameterException_forNull() throws IOException {
        tldValidator.isValidTld(null);
    }
}
