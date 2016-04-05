package com.fewlaps.quitnowemailsuggester.util;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringUtilsTest {

    StringUtils su;

    @Before
    public void init() {
        su = new StringUtils();
    }

    @Test
    public void shouldReturnEmpty1() {
        assertEquals("", su.replaceLast("", "", ""));
    }

    @Test
    public void shouldReturnEmpty2() {
        assertEquals("", su.replaceLast("", "ll", "xx"));
    }

    @Test
    public void shouldReturnHeo() {
        assertEquals("heo", su.replaceLast("hello", "ll", ""));
    }

    @Test
    public void shouldReturnAaabxx() {
        assertEquals("aaabxx", su.replaceLast("aaabbb", "bb", "xx"));
    }
}
