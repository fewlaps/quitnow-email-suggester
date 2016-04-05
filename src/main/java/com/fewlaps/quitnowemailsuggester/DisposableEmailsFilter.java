package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.exception.InvalidEmailException;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class DisposableEmailsFilter {

    private final String FILE_LOCATION = "disposables/index.json";

    private EmailParts ep = new EmailParts();

    public String getFileContent() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_LOCATION).getFile());
        Scanner scanner = new Scanner(file);
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        return text;
    }

    public boolean isDisposable(String email) throws FileNotFoundException, InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidParameterException("The email can't be null or blank");
        }

        String domain = ep.getDomain(email);
        String fileContent = getFileContent();
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
