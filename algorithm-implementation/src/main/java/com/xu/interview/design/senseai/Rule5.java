package com.xu.interview.design.senseai;


public class Rule5 extends Rule {
    @Override
    protected String execute(int n) {
        return "B";
    }

    @Override
    protected boolean verify(int n) {
        return n % 5 == 0;
    }
}
