package com.fewlaps.quitnowemailsuggester;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class StringAlphanumericValidatorTest {

    StringValidator sv;

    @Before
    public void init() {
        sv = new StringValidator();
    }

    @Test
    public void shouldReturnTrueFor1234() {
        assertTrue(sv.isAlphanumeric("1234"));
    }

    @Test
    public void shouldReturnTrueForCAFEBABE() {
        assertTrue(sv.isAlphanumeric("CAFEBABE"));
    }

    @Test
    public void shouldReturnTrueFor12CD() {
        assertTrue(sv.isAlphanumeric("12CD"));
    }

    @Test
    public void shouldReturnFalseForTextWithSymbols1() {
        assertFalse(sv.isAlphanumeric("42!"));
    }

    @Test
    public void shouldReturnFalseForTextWithSymbols2() {
        assertFalse(sv.isAlphanumeric("@42"));
    }

    @Test
    public void shouldReturnFalseForTextWithSymbols3() {
        assertFalse(sv.isAlphanumeric("42-"));
    }

    @Test
    public void shouldReturnFalseForTextWithSymbols4() {
        assertFalse(sv.isAlphanumeric("+42"));
    }

    @Test
    public void shouldReturnFalseForTextWithSymbols5() {
        assertFalse(sv.isAlphanumeric("CAFEBABE!?$%&/)"));
    }
}
