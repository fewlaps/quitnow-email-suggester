package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class EmailValidatorTest {

    EmailValidator ev;

    @Before
    public void init() {
        ev = new EmailValidator();
    }

    //region isValidEmailSyntax
    @Test
    public void shouldSayFalseForNull() {
        assertFalse(ev.hasGoodSyntax(null));
    }

    @Test
    public void shouldSayFalseForEmpty() {
        assertFalse(ev.hasGoodSyntax(""));
    }

    @Test
    public void shouldSayOK1() {
        assertTrue(ev.hasGoodSyntax("roc@rocboron.at"));
    }

    @Test
    public void shouldSayOK2() {
        assertTrue(ev.hasGoodSyntax("email@example.com"));
    }

    @Test
    public void shouldSayOK3() {
        assertTrue(ev.hasGoodSyntax("firstname.lastname@example.com"));
    }

    @Test
    public void shouldSayOK4() {
        assertTrue(ev.hasGoodSyntax("email@subdomain.example.com"));
    }

    @Test
    public void shouldSayOK5() {
        assertTrue(ev.hasGoodSyntax("firstname+lastname@example.com"));
    }

    @Test
    public void shouldSayOK6() {
        assertTrue(ev.hasGoodSyntax("1234567890@example.com"));
    }

    @Test
    public void shouldSayOK7() {
        assertTrue(ev.hasGoodSyntax("email@example-one.com"));
    }

    @Test
    public void shouldSayOK8() {
        assertTrue(ev.hasGoodSyntax("_______@example.com"));
    }

    @Test
    public void shouldSayOK9() {
        assertTrue(ev.hasGoodSyntax("email@example.name"));
    }

    @Test
    public void shouldSayOK10() {
        assertTrue(ev.hasGoodSyntax("email@example.museum"));
    }

    @Test
    public void shouldSayOK11() {
        assertTrue(ev.hasGoodSyntax("email@example.co.jp"));
    }

    @Test
    public void shouldSayOK12() {
        assertTrue(ev.hasGoodSyntax("firstname-lastname@example.com"));
    }

    @Test
    public void shouldSayKO1() {
        assertFalse(ev.hasGoodSyntax("plainaddress"));
    }

    @Test
    public void shouldSayKO2() {
        assertFalse(ev.hasGoodSyntax("#@%^%#$@#$@#.com"));
    }

    @Test
    public void shouldSayKO3() {
        assertFalse(ev.hasGoodSyntax("@example.com"));
    }

    @Test
    public void shouldSayKO4() {
        assertFalse(ev.hasGoodSyntax("Joe Smith <email@example.com>"));
    }

    @Test
    public void shouldSayKO5() {
        assertFalse(ev.hasGoodSyntax("email.example.com"));
    }

    @Test
    public void shouldSayKO6() {
        assertFalse(ev.hasGoodSyntax("email@example@example.com"));
    }

    @Test
    public void shouldSayKO7() {
        assertTrue(ev.hasGoodSyntax(".email@example.com"));
    }

    @Test
    public void shouldSayKO8() {
        assertTrue(ev.hasGoodSyntax("email.@example.com"));
    }

    @Test
    public void shouldSayKO9() {
        assertTrue(ev.hasGoodSyntax("email..email@example.com"));
    }

    @Test
    public void shouldSayKO10() {
        assertFalse(ev.hasGoodSyntax("?????@example.com"));
    }

    @Test
    public void shouldSayKO11() {
        assertFalse(ev.hasGoodSyntax("email@example.com (Joe Smith)"));
    }

    @Test
    public void shouldSayKO12() {
        assertFalse(ev.hasGoodSyntax("email@example"));
    }

    @Test
    public void shouldSayKO13() {
        assertTrue(ev.hasGoodSyntax("email@111.222.333.44444"));
    }

    @Test
    public void shouldSayKO14() {
        assertFalse(ev.hasGoodSyntax("email@example..com"));
    }

    @Test
    public void shouldSayKO15() {
        assertTrue(ev.hasGoodSyntax("Abc..123@example.com"));
    }

    @Test
    public void shouldSayKO16() {
        assertFalse(ev.hasGoodSyntax("�(),:;<>[\\]@example.com"));
    }

    @Test
    public void shouldSayKO17() {
        assertFalse(ev.hasGoodSyntax("just\"not\"right@example.com"));
    }

    @Test
    public void shouldSayKO18() {
        assertFalse(ev.hasGoodSyntax("this\\ is\"really\"not\\allowed@example.com"));
    }
    //endregion

    //region .isAlias()
    @Test
    public void aliasTest01() {
        assertTrue(ev.isAlias("alias+test@example.com"));
    }

    @Test
    public void aliasTest02() {
        assertTrue(ev.isAlias("alias+test+me@example.com"));
    }

    @Test
    public void aliasTest03() {
        assertTrue(ev.isAlias("alias+e@example.com"));
    }

    @Test
    public void aliasTest04() {
        assertFalse(ev.isAlias("alias@example.com"));
    }

    @Test
    public void aliasTest05() {
        assertFalse(ev.isAlias("alias+me@.example.com"));
    }
    //endregion

    //region .hasValidTld
    @Test
    public void checkValidTld01() throws InvalidEmailException {
        assertTrue(ev.hasValidTld("something@fewlaps.co.uk"));
    }

    @Test
    public void checkValidTld02() throws InvalidEmailException {
        assertTrue(ev.hasValidTld("something@fewlaps.com"));
    }

    @Test
    public void checkValidTldBarcelona() throws InvalidEmailException {
        assertTrue(ev.hasValidTld("something@fewlaps.barcelona"));
    }

    @Test
    public void shouldReturnFalse_forInvalidCon() throws InvalidEmailException {
        assertFalse(ev.hasValidTld("something@fewlaps.con"));
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldLaunchAnInvalidParameterException_forBlank() throws InvalidEmailException {
        ev.hasValidTld("");
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldLaunchAnInvalidParameterException_forNull() throws InvalidEmailException {
        ev.hasValidTld(null);
    }
    //endregion

    //region .isDisposable()
    @Test
    public void shouldSayTrue_fakeInboxCom() throws InvalidEmailException {
        String email = "something@fakeinbox.com";
        boolean result = ev.isDisposable(email);
        assertTrue(result);
    }

    @Test
    public void shouldSayFalse_fewlapsCom() throws InvalidEmailException {
        String email = "something@fewlaps.com";
        boolean result = ev.isDisposable(email);
        assertFalse(result);
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldLaunchAnException_whenEmailIsNull() throws InvalidEmailException {
        String email = null;
        ev.isDisposable(email);
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldLaunchAnException_whenEmailIsBlank() throws InvalidEmailException {
        String email = "";
        ev.isDisposable(email);
    }
    //endregion
}
