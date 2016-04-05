package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This will use the most common e-mails, testing that they are valid and the suggested emails are not different as the sent ones
 */
public class GoodEmailsTest {

    EmailSuggester es;
    EmailSyntaxValidator ev;

    @Before
    public void init() {
        es = new EmailSuggester();
        ev = new EmailSyntaxValidator();
    }

    @Test
    public void shouldBeValidAndUnsuggestedRocboronatDotNet() throws InvalidEmailException {
        String email = "roc@rocboronat.net";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggestedRocbonDotAt() throws InvalidEmailException {
        String email = "roc@rocboron.at";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggestedFewlaps() throws InvalidEmailException {
        String email = "roc@fewlaps.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggestedDotCo() throws InvalidEmailException {
        String email = "roc@roc.co";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested1() throws InvalidEmailException {
        String email = "roc@gmail.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested2() throws InvalidEmailException {
        String email = "roc@hotmail.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested3() throws InvalidEmailException {
        String email = "roc@yahoo.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested4() throws InvalidEmailException {
        String email = "roc@hotmail.fr";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested5() throws InvalidEmailException {
        String email = "roc@mail.ru";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested6() throws InvalidEmailException {
        String email = "roc@web.de";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested7() throws InvalidEmailException {
        String email = "roc@outlook.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested8() throws InvalidEmailException {
        String email = "roc@gmx.de";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested9() throws InvalidEmailException {
        String email = "roc@live.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested10() throws InvalidEmailException {
        String email = "roc@hotmail.it";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested11() throws InvalidEmailException {
        String email = "roc@googlemail.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested12() throws InvalidEmailException {
        String email = "roc@aol.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested13() throws InvalidEmailException {
        String email = "roc@libero.it";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested14() throws InvalidEmailException {
        String email = "roc@yahoo.fr";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested15() throws InvalidEmailException {
        String email = "roc@live.nl";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested16() throws InvalidEmailException {
        String email = "roc@yahoo.de";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested17() throws InvalidEmailException {
        String email = "roc@hotmail.co";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested18() throws InvalidEmailException {
        String email = "roc@icloud.com";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested19() throws InvalidEmailException {
        String email = "roc@yandex.ru";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested20() throws InvalidEmailException {
        String email = "roc@live.fr";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }

    @Test
    public void shouldBeValidAndUnsuggested21() throws InvalidEmailException {
        String email = "fewlaps@something.com.pe";
        assertTrue(ev.isValidEmail(email));
        assertEquals(email, es.getSuggestedEmail(email));
    }
}
