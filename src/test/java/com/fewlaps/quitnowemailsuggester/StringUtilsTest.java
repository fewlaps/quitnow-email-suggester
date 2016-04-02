package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import com.fewlaps.quitnowemailsuggester.util.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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


    @Test
    public void shouldReturnNullForNull() throws InvalidEmailException {
        String[] parts = su.getParts(null);
        assertNull(parts);
    }

    @Test
    public void shouldReturnArrayWithxZeroElementsFromEmpty() throws InvalidEmailException {
        String[] elements = su.getParts("");

        Assert.assertEquals(elements.length, 0);
    }

    @Test
    public void shouldReturnArrayWithOneElementFromSimpleEmail() throws InvalidEmailException {
        String[] elements = su.getParts("bernat.borras@example.com");

        Assert.assertEquals(elements.length, 1);
    }

    @Test
    public void shouldReturnArrayWithTwoElementFromTwoEmails_whenNullSeparator() throws InvalidEmailException {
        String[] elements = su.getParts("bernat.borras@example.com:Office365", null);

        Assert.assertEquals(elements.length, 2);
    }

    @Test
    public void shouldReturnArrayWithTwoElementFromTwoEmails_whenEmptySeparator() throws InvalidEmailException {
        String[] elements = su.getParts("bernat.borras@example.com:Office365", "");

        Assert.assertEquals(elements.length, 2);
    }

    @Test
    public void shouldReturnArrayWithTwoElementFromTwoEmails() throws InvalidEmailException {
        String[] elements = su.getParts("bernat.borras@example.com:Office365");

        Assert.assertEquals(elements.length, 2);
    }

    @Test
    public void shouldReturnArrayWithTwoElementFromTwoPartsWithColon() throws InvalidEmailException {
        String[] elements = su.getParts("bernat.borras@example.com,Office365", ",");

        Assert.assertEquals(elements.length, 2);
    }
}
