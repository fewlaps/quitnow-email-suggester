package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EmailSuggestorBadEmailsTest {

    EmailSuggester es;

    @Before
    public void init() {
        es = new EmailSuggester();
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNull() throws InvalidEmailException {
        try {
            es.getSuggestedEmail(null);
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForEmpty() throws InvalidEmailException {
        try {
            es.getSuggestedEmail("");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForAnInvalidEmail() throws InvalidEmailException {
        try {
            es.getSuggestedEmail("roc@roc@roc");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        }
    }

    @Test
    public void shouldFixDotConIssue1() throws InvalidEmailException {
        assertEquals("roc@rocboronat.com", es.getSuggestedEmail("roc@rocboronat.con"));

    }

    @Test
    public void shouldFixDotConIssue2() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.con"));

    }

    @Test
    public void shouldFixDotConIssue3() throws InvalidEmailException {
        assertEquals("a@b.com", es.getSuggestedEmail("a@b.con"));

    }

    @Test
    public void shouldFixDotNeyIssue() throws InvalidEmailException {
        assertEquals("a@b.net", es.getSuggestedEmail("a@b.ney"));

    }

    @Test
    public void shouldFixGnailIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.com"));

    }

    @Test
    public void shouldFixGmailDotOmIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.om"));

    }

    @Test
    public void shouldFixGnailAndConIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.con"));

    }

    @Test
    public void shouldFixGmialIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.com"));

    }

    @Test
    public void shouldFixGmialAndConIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.con"));

    }

    @Test
    public void shouldFixDotCpmIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.cpm"));

    }

    @Test
    public void shouldFixDotCpnIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.cpn"));

    }

    @Test
    public void shouldFixGmailDotCxomIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.cxom"));

    }

    @Test
    public void shouldFixGmailDotCoIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.co"));

    }

    @Test
    public void shouldNotDoNothingWithYahooDotCo() throws InvalidEmailException {
        assertEquals("roc@yahoo.co", es.getSuggestedEmail("roc@yahoo.co"));

    }

    @Test
    public void shouldFixYahooDotOm() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yahoo.om"));

    }

    @Test
    public void shouldFixGmailDotCommIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.comm"));
    }

    @Test
    public void shouldFixGmailDotColIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.col"));
    }

    @Test
    public void shouldFixGmaiDotComIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmai.com"));
    }

    @Test
    public void shouldFixGimailDotComIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gimail.com"));
    }

    @Test
    public void shouldFixGmaailDotComIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmaail.com"));
    }

    @Test
    public void shouldFixGamilDotComIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gamil.com"));
    }

    @Test
    public void shouldFixGmalDotComIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmal.com"));
    }

    @Test
    public void shouldFixYgmailDotComIssue() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@ygmail.com"));
    }

    @Test
    public void shouldFixHotmaiDotComIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmai.com"));
    }

    @Test
    public void shouldFixHotmalDotComIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmal.com"));
    }

    @Test
    public void shouldFixHotmaliDotComIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmali.com"));
    }

    @Test
    public void shouldFixHitmailDotComIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hitmail.com"));
    }

    @Test
    public void shouldFixHotmialDotComIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmial.com"));
    }

    @Test
    public void shouldFixHotmaleDotComIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmale.com"));
    }

    @Test
    public void shouldFixHitmailDotItIssue() throws InvalidEmailException {
        assertEquals("roc@hotmail.it", es.getSuggestedEmail("roc@hitmail.it"));
    }

    @Test
    public void shouldFixYahooDotConIssue() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yahoo.con"));
    }

    @Test
    public void shouldFixYaooDotComIssue() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaoo.com"));
    }

    @Test
    public void shouldFixYaooDotConIssue() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaoo.con"));
    }

    @Test
    public void shouldFixYabooDotConIssue() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaboo.con"));
    }

    @Test
    public void shouldFixYabooDotComlIssue() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaboo.coml"));
    }

    @Test
    public void shouldFixYaboDotConIssue() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaho.com"));
    }

    @Test
    public void shouldFixOutllokIssue() throws InvalidEmailException {
        assertEquals("roc@outlook.com", es.getSuggestedEmail("roc@outllok.com"));
    }

    @Test
    public void shouldFixComaIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.coma"));
    }

    @Test
    public void shouldFixCombIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.comb"));
    }

    @Test
    public void shouldFixComcIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.comc"));
    }

    @Test
    public void shouldFixComxIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.comx"));
    }

    @Test
    public void shouldFixComyIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.comy"));
    }

    @Test
    public void shouldFixComzIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.comz"));
    }

    @Test
    public void shouldFixAcomIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.acom"));
    }

    @Test
    public void shouldFixBcomIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.bcom"));
    }

    @Test
    public void shouldFixCcomIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.ccom"));
    }

    @Test
    public void shouldFixXcomIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.xcom"));
    }

    @Test
    public void shouldFixYcomIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.ycom"));
    }

    @Test
    public void shouldFixZcomIssue() throws InvalidEmailException {
        assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.zcom"));
    }

    @Test
    public void shouldFixNteIssue() throws InvalidEmailException {
        assertEquals("roc@rocboronat.net", es.getSuggestedEmail("roc@rocboronat.nte"));
    }

    @Test
    public void shouldFixOutilookDotCom() throws InvalidEmailException {
        assertEquals("roc@outlook.com", es.getSuggestedEmail("roc@outilook.com"));
    }

    @Test
    public void shouldFixGmailDotComu() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.comu"));
    }

    @Test
    public void shouldFixHotnailDotCom() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotnail.com"));
    }

    @Test
    public void shouldFixHormailDotCom() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hormail.com"));
    }

    @Test
    public void shouldReplaceFtToFr() throws InvalidEmailException {
        assertEquals("roc@hotmail.fr", es.getSuggestedEmail("roc@hotmail.ft"));
    }

    @Test
    public void shouldReplaceFeToFr() throws InvalidEmailException {
        assertEquals("roc@hotmail.fr", es.getSuggestedEmail("roc@hotmail.fe"));
    }

    @Test
    public void shouldFixGmaikDotCom() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmaik.com"));
    }

    @Test
    public void shouldFixYahou() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yahou.com"));
    }

    @Test
    public void shouldFixGmailDotVom() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.vom"));
    }

    @Test
    public void shouldFixHotmmailDotCom() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmmail.com"));
    }

    @Test
    public void shouldFixUahooDotCom() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@uahoo.com"));
    }

    @Test
    public void shouldFixGmaliDotCom() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmali.com"));
    }

    @Test
    public void shouldFixHotmailDotCm() throws InvalidEmailException {
        assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmail.cm"));
    }

    @Test
    public void shouldFixYhooDotCom() throws InvalidEmailException {
        assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yhoo.com"));
    }

    @Test
    public void shouldFixGemalDotCom() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gemail.com"));
    }

    @Test
    public void shouldFixGmailDotClm() throws InvalidEmailException {
        assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.clm"));
    }
}
