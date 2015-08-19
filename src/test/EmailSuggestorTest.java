package test;

import at.rocboron.emailverifier.EmailSuggester;
import at.rocboron.emailverifier.exception.InvalidEmailException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EmailSuggestorTest {

    EmailSuggester es;

    @Before
    public void init() throws InvalidEmailException {
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
}
