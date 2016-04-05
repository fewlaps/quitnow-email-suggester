package com.fewlaps.quitnowemailsuggester.bean;

public class EmailCorrection {
    private final String badEnd;
    private final String goodEnd;

    public EmailCorrection(String badEnd, String goodEnd) {
        this.badEnd = badEnd;
        this.goodEnd = goodEnd;
    }

    public String getBadEnd() {
        return badEnd;
    }

    public String getGoodEnd() {
        return goodEnd;
    }
}
