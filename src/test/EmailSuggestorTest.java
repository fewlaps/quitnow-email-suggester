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
    public void init() {
        es = new EmailSuggester();
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForNull() {
        try {
            es.getSuggestedEmail(null);
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForEmpty() {
        try {
            es.getSuggestedEmail("");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldLaunchAnInvalidEmailExceptionForAnInvalidEmail() {
        try {
            es.getSuggestedEmail("roc@roc@roc");
        } catch (InvalidEmailException e) {
            return; //This is what we expect
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotConIssue1() {
        try {
            assertEquals("roc@rocboronat.com", es.getSuggestedEmail("roc@rocboronat.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotConIssue2() {
        try {
            assertEquals("roc@fewlaps.com", es.getSuggestedEmail("roc@fewlaps.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotConIssue3() {
        try {
            assertEquals("a@b.com", es.getSuggestedEmail("a@b.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotNeyIssue() {
        try {
            assertEquals("a@b.net", es.getSuggestedEmail("a@b.ney"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGnailIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmailDotOmIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.om"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGnailAndConIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gnail.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmialIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmialAndConIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotCpmIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.cpm"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixDotCpnIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmial.cpn"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmailDotCxomIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.cxom"));
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void shouldFixGmailDotCoIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.co"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldNotDoNothingWithYahooDotCo() {
        try {
            assertEquals("roc@yahoo.co", es.getSuggestedEmail("roc@yahoo.co"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYahooDotOm() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yahoo.om"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmailDotCommIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.comm"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
     public void shouldFixGmailDotColIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmail.col"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmaiDotComIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmai.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGimailDotComIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gimail.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmaailDotComIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmaail.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGamilDotComIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gamil.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixGmalDotComIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@gmal.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYgmailDotComIssue() {
        try {
            assertEquals("roc@gmail.com", es.getSuggestedEmail("roc@ygmail.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHotmaiDotComIssue() {
        try {
            assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmai.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHotmalDotComIssue() {
        try {
            assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmal.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHotmaliDotComIssue() {
        try {
            assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmali.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHitmailDotComIssue() {
        try {
            assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hitmail.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHotmialDotComIssue() {
        try {
            assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmial.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHotmaleDotComIssue() {
        try {
            assertEquals("roc@hotmail.com", es.getSuggestedEmail("roc@hotmale.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixHitmailDotItIssue() {
        try {
            assertEquals("roc@hotmail.it", es.getSuggestedEmail("roc@hitmail.it"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYahooDotConIssue() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yahoo.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYaooDotComIssue() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaoo.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYaooDotConIssue() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaoo.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYabooDotConIssue() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaboo.con"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYabooDotComlIssue() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaboo.coml"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixYaboDotConIssue() {
        try {
            assertEquals("roc@yahoo.com", es.getSuggestedEmail("roc@yaho.com"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void shouldFixOutllokIssue() {
        try {
            assertEquals("roc@outlook.com", es.getSuggestedEmail("roc@outllok.com"));
        } catch (Exception e) {
            fail();
        }
    }
}
