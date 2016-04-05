package com.fewlaps.quitnowemailsuggester;

import com.fewlaps.quitnowemailsuggester.file.QuitNowEmailSuggesterFilesReader;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

public class TldValidator {
    public boolean isValidTld(String suffix) throws IOException {
        if (suffix == null || suffix.isEmpty()) {
            throw new InvalidParameterException("The suffix can't be null or blank");
        }

        suffix = suffix.trim();
        List<String> lines = new QuitNowEmailSuggesterFilesReader().getTlds();

        for (String line : lines) {
            if (line.trim().equalsIgnoreCase(suffix)) {
                return true;
            }
        }
        return false;
    }
}
