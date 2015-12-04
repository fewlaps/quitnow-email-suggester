package com.fewlaps.quitnowemailsuggester;

public class EmailCorrection {
    private String badEnd;
    private String goodEnd;

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
