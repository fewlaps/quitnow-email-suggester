package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import com.fewlaps.quitnowemailsuggester.file.QuitNowEmailSuggesterFilesReader;

import java.io.IOException;
import java.security.InvalidParameterException;

public class DisposableEmailsFilter {

    private EmailParts ep = new EmailParts();

    public boolean isDisposable(String email) throws IOException, InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidParameterException("The email can't be null or blank");
        }

        String domain = ep.getDomain(email);
        String[] disposables = new QuitNowEmailSuggesterFilesReader().getDisposables();

        for (String disposable : disposables) {
            if (disposable.equals(domain)) {
                return true;
            }
        }
        return false;
    }
}
