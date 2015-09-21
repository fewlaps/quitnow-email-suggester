package com.fewlaps.quitnowemailsuggester.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by edgeorge on 15/09/15.
 */
public class SuffixUtils {
    private final String FILE_LOCATION = "list/public_suffix_list.dat";


    public Scanner getFileScanner() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_LOCATION).getFile());

        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isValidSuffix(String suffix) {

        if(suffix == null || suffix.isEmpty())
            return false;

        Scanner scanner = getFileScanner();
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(suffix)) {
                    return true;
                }
            }
            return false;
        }finally {
            scanner.close();
        }
    }

}
