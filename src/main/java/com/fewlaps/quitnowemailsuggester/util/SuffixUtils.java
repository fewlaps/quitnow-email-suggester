package com.fewlaps.quitnowemailsuggester.util;

import com.fewlaps.quitnowemailsuggester.file.FileUtils;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

public class SuffixUtils {
    private final String FILE_LOCATION = "list/public_suffix_list.dat";

    public boolean isValidSuffix(String suffix) throws IOException {
        if (suffix == null || suffix.isEmpty()) {
            throw new InvalidParameterException("The suffix can't be null or blank");
        }

        suffix = suffix.trim();
        List<String> lines = new FileUtils().getFileLines(FILE_LOCATION);

        for (String line : lines) {
            if (line.trim().equalsIgnoreCase(suffix)) {
                return true;
            }
        }
        return false;
    }
}
