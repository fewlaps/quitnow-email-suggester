package test;

import at.rocboron.emailverifier.EmailSuggester;
import at.rocboron.emailverifier.EmailValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * This will use the most common e-mails, testing that they are valid and the suggested emails are not different as the sent ones
 */
public class CommonEmailsTest {

    EmailSuggester es;
    EmailValidator ev;

    @Before
    public void init() {
        es = new EmailSuggester();
        ev = new EmailValidator();
    }

    @Test
    public void shouldBeValidAndUnsuggestedRocboronatDotNet() {
        try {
            String email = "roc@rocboronat.net";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggestedRocbonDotAt() {
        try {
            String email = "roc@rocboron.at";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggestedFewlaps() {
        try {
            String email = "roc@fewlaps.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested1() {
        try {
            String email = "roc@gmail.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested2() {
        try {
            String email = "roc@hotmail.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested3() {
        try {
            String email = "roc@yahoo.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested4() {
        try {
            String email = "roc@hotmail.fr";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested5() {
        try {
            String email = "roc@mail.ru";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested6() {
        try {
            String email = "roc@web.de";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested7() {
        try {
            String email = "roc@outlook.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested8() {
        try {
            String email = "roc@gmx.de";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested9() {
        try {
            String email = "roc@live.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested10() {
        try {
            String email = "roc@hotmail.it";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested11() {
        try {
            String email = "roc@googlemail.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested12() {
        try {
            String email = "roc@aol.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested13() {
        try {
            String email = "roc@libero.it";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested14() {
        try {
            String email = "roc@yahoo.fr";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested15() {
        try {
            String email = "roc@live.nl";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested16() {
        try {
            String email = "roc@yahoo.de";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested17() {
        try {
            String email = "roc@hotmail.co";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested18() {
        try {
            String email = "roc@icloud.com";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested19() {
        try {
            String email = "roc@yandex.ru";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldBeValidAndUnsuggested20() {
        try {
            String email = "roc@live.fr";
            assertTrue(ev.isValidEmail(email));
            assertEquals(email, es.getSuggestedEmail(email));
        } catch (Exception e) {
            fail();
        }
    }
}
