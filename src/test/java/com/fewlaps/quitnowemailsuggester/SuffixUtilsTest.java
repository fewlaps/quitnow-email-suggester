package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.util.SuffixUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SuffixUtilsTest {

    SuffixUtils su;

    @Before
    public void init() {
        su = new SuffixUtils();
    }

    @Test
    public void checkValidSuffix01() throws IOException {
        assertTrue(su.isValidSuffix("co.uk"));
    }

    @Test
    public void checkValidSuffix02() throws IOException {
        assertTrue(su.isValidSuffix("com"));
    }

    @Test
    public void checkValidSuffix03() throws IOException {
        assertFalse(su.isValidSuffix("con"));
    }

    @Test(expected = InvalidParameterException.class)
    public void checkValidSuffix04() throws IOException {
        assertFalse(su.isValidSuffix(""));
    }

    @Test(expected = InvalidParameterException.class)
    public void checkValidSuffix05() throws IOException {
        assertFalse(su.isValidSuffix(null));
    }

    @Test
    public void checkValidSuffixBarcelona() throws IOException {
        assertTrue(su.isValidSuffix("barcelona"));
    }

}
