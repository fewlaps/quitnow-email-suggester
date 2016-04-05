package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import com.fewlaps.quitnowemailsuggester.file.FileUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class DisposableEmailsFilter {

    private final String FILE_LOCATION = "disposables/index.json";

    private EmailParts ep = new EmailParts();

    public boolean isDisposable(String email) throws IOException, InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidParameterException("The email can't be null or blank");
        }

        String domain = ep.getDomain(email);
        String fileContent = new FileUtils().getFileContent(FILE_LOCATION);
        Gson gson = new Gson();
        String[] disposables = gson.fromJson(fileContent, String[].class);

        for (String disposable : disposables) {
            if (disposable.equals(domain)) {
                return true;
            }
        }
        return false;
    }
}
