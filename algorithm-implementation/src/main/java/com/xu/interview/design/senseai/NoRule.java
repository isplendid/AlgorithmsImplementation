package com.xu.interview.design.senseai;

public class NoRule extends Rule{
    @Override
    protected String execute(int n) {
        return String.valueOf(n);
    }

    @Override
    protected boolean verify(int n) {
        return true;
    }
}
