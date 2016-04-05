package com.fewlaps.quitnowemailsuggester;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndroidAccountEmailCleanerTest {

    AndroidAccountEmailCleaner aaec;

    @Before
    public void init() {
        aaec = new AndroidAccountEmailCleaner();
    }

    @Test
    public void shouldRemainTheSame_whenEmailIsAValidOne() {
        String email = "roc@fewlaps.com";
        String result = aaec.cleanEmail(email);
        assertEquals(email, result);
    }

    @Test
    public void shouldRemoveNonEmailPart_whenEmailHasIt() {
        String email = "bernat.borras@example.com:Office";
        String result = aaec.cleanEmail(email);
        assertEquals("bernat.borras@example.com", result);
    }
}
