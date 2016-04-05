package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class DisposableEmailsFilterTest {

    DisposableEmailsFilter def;

    @Before
    public void init() {
        def = new DisposableEmailsFilter();
    }

    @Test
    public void shouldSayTrue_fakeInboxCom() throws IOException, InvalidEmailException {
        String email = "something@fakeinbox.com";
        boolean result = def.isDisposable(email);
        assertTrue(result);
    }

    @Test
    public void shouldSayFalse_fewlapsCom() throws IOException, InvalidEmailException {
        String email = "something@fewlaps.com";
        boolean result = def.isDisposable(email);
        assertFalse(result);
    }
}
