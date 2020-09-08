package com.xu.interview.design.senseai;

public abstract class  Rule {

    private Rule successor;

    public String print(int n){
        return verify(n) ? execute(n):successor.print(n);
    }

    protected abstract String execute(int n);

    protected abstract boolean verify(int n);

    public void setSuccessor(Rule successor){
        this.successor = successor;
    }

}
