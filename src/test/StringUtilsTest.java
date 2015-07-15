package test;

import at.rocboron.emailverifier.EmailValidator;
import at.rocboron.emailverifier.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class StringUtilsTest {

    StringUtils su;

    @Before
    public void init() {
        su = new StringUtils();
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
