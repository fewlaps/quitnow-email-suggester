package com.fewlaps.quitnowemailsuggester;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class StringNumericValidatorTest {

    StringValidator sv;

    @Before
    public void init() {
        sv = new StringValidator();
    }

    @Test
    public void shouldNumericReturnTrueFor1234() {
        assertTrue(sv.isNumeric("1234"));
    }

    @Test
    public void shouldNumericReturnFalseFor12Space34() {
        assertFalse(sv.isNumeric("12 34"));
    }

    @Test
    public void shouldNumericReturnFalseForAbcd() {
        assertFalse(sv.isNumeric("ABCD"));
    }

    @Test
    public void shouldNumericReturnFalseForAb42() {
        assertFalse(sv.isNumeric("AB42"));
    }

    @Test
    public void shouldHasNumberReturnTrueFor1234() {
        assertTrue(sv.hasNumber("1234"));
    }

    @Test
    public void shouldHasNumberReturnTrueForAb3D() {
        assertTrue(sv.hasNumber("AB3D"));
    }

    @Test
    public void shouldHasNumberReturnFalseForAbcd() {
        assertFalse(sv.hasNumber("ABCD"));
    }

    @Test
    public void shouldHasNumberReturnTrueForA234() {
        assertTrue(sv.hasNumber("A234"));
    }
}
