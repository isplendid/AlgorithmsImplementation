package com.xu.interview.design.senseai;

public class Rule35 extends Rule {
    @Override
    protected String execute(int n) {
        return "AB";
    }

    @Override
    protected boolean verify(int n) {
        return n % 3==0 && n % 5==0;
    }
}
