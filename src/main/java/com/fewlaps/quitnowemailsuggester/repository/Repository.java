package com.fewlaps.quitnowemailsuggester.repository;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {

    private final String SUFFIX_FILE_LOCATION = "list/public_suffix_list.dat";
    private final String DISPOSABLES_FILE_LOCATION = "disposables/index.json";

    public List<String> getTlds() {
        try {
            List<String> lines = new ArrayList();
            FileInputStream inputStream = null;
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            File file = new File(classLoader.getResource(SUFFIX_FILE_LOCATION).getFile());
            Scanner sc = null;
            try {
                inputStream = new FileInputStream(file);
                sc = new Scanner(inputStream, "UTF-8");
                while (sc.hasNextLine()) {
                    lines.add(sc.nextLine());
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            }

            return lines;
        } catch (IOException e) {
            return null;
        }
    }

    public String[] getDisposables() {
        try {
            StringBuilder sb = new StringBuilder();
            FileInputStream inputStream = null;
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            File file = new File(classLoader.getResource(DISPOSABLES_FILE_LOCATION).getFile());
            Scanner sc = null;
            try {
                inputStream = new FileInputStream(file);
                sc = new Scanner(inputStream, "UTF-8");
                while (sc.hasNextLine()) {
                    sb.append(sc.nextLine());
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            }

            Gson gson = new Gson();
            return gson.fromJson(sb.toString(), String[].class);
        } catch (IOException e) {
            return null;
        }
    }
}
