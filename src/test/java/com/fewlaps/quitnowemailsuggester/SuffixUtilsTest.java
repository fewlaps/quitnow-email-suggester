package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.util.SuffixUtils;
import org.junit.Before;
import org.junit.Test;

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
    public void shouldGetFileScanner(){
        assertTrue(su.getFileScanner() != null);
    }

    @Test
    public void checkValidSuffix01(){
        assertTrue(su.isValidSuffix("co.uk"));
    }

    @Test
    public void checkValidSuffix02(){
        assertTrue(su.isValidSuffix("com"));
    }

    @Test
    public void checkValidSuffix03(){
        assertFalse(su.isValidSuffix("con"));
    }

    @Test
    public void checkValidSuffix04(){
        assertFalse(su.isValidSuffix(""));
    }

    @Test
    public void checkValidSuffix05(){
        assertFalse(su.isValidSuffix(null));
    }


}
