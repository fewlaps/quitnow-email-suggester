package com.fewlaps.quitnowemailsuggester.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by edgeorge on 15/09/15.
 */
public class SuffixUtils {
    private final String FILE_LOCATION = "../resources/list/public_suffix_list.dat";


    public Scanner getFileScanner(){
        try {
            return new Scanner(new File(FILE_LOCATION));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isValidSuffix(String suffix){
        Scanner scanner = getFileScanner();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.equals(suffix)){
                return true;
            }
        }
        return false;
    }


}
