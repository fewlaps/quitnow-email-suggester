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

    public void setBadEnd(String badEnd) {
        this.badEnd = badEnd;
    }

    public String getGoodEnd() {
        return goodEnd;
    }

    public void setGoodEnd(String goodEnd) {
        this.goodEnd = goodEnd;
    }
}
