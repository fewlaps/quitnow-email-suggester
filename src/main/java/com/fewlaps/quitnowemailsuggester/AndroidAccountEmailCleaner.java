package com.fewlaps.quitnowemailsuggester;

public class AndroidAccountEmailCleaner {

    public static final String ANDROID_ACCOUNT_SUFFIX_SEPARATOR = ":";

    public String cleanEmail(String androidAccountEmail) {
        return androidAccountEmail.split(ANDROID_ACCOUNT_SUFFIX_SEPARATOR)[0];
    }
}
