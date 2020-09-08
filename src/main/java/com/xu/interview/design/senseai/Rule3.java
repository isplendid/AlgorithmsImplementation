package com.xu.interview.design.senseai;


public class Rule3 extends Rule {
    @Override
    protected String execute(int n) {
        return "A";
    }

    @Override
    protected boolean verify(int n) {
        return n % 3 == 0;
    }
}
