package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.util.SuffixUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by edgeorge on 15/09/15.
 */
public class SuffixUtilsTest {

    SuffixUtils su;

    @Before
    public void init() {
        su = new SuffixUtils();
    }

    @Test
    public void shouldGetFileScanner() throws FileNotFoundException {
        assertTrue(su.getFileScanner() != null);
    }

    @Test
    public void checkValidSuffix01() throws FileNotFoundException {
        assertTrue(su.isValidSuffix("co.uk"));
    }

    @Test
    public void checkValidSuffix02() throws FileNotFoundException {
        assertTrue(su.isValidSuffix("com"));
    }

    @Test
    public void checkValidSuffix03() throws FileNotFoundException {
        assertFalse(su.isValidSuffix("con"));
    }

    @Test
    public void checkValidSuffix04() throws FileNotFoundException {
        assertFalse(su.isValidSuffix(""));
    }

    @Test
    public void checkValidSuffix05() throws FileNotFoundException {
        assertFalse(su.isValidSuffix(null));
    }

    @Test
    public void checkValidSuffixBarcelona() throws FileNotFoundException {
        assertTrue(su.isValidSuffix("barcelona"));
    }

}
