package com.fewlaps.quitnowemailsuggester;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class EmailSplitValidatorTest {

    EmailValidator ev;

    @Before
    public void init() {
        ev = new EmailValidator();
    }

    @Test
    public void shouldReturnOKWithEmailOnFirstPart() {
        assertTrue(ev.isValidEmail("email@example.com:something"));
    }

    @Test
    public void shouldReturnOKWithEmailOnSecondPart() {
        assertTrue(ev.isValidEmail("something:email@example.com"));
    }

    @Test
    public void shouldReturnKOWithInvalidEmailOnFirstPart() {
        assertFalse(ev.isValidEmail("email@example:something"));
    }

    @Test
    public void shouldReturnKOWithInvalidEmailOnSecondPart() {
        assertFalse(ev.isValidEmail("something:email@example"));
    }
}
