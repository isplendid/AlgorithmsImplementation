package com.xu.interview.design.senseai;

import java.util.ArrayList;
import java.util.List;

public class PrintValue {
    private Rule rule;

    public PrintValue(){
        rule = new Rule35();
        Rule rule3 = new Rule3();
        Rule rule5 = new Rule5();
        Rule noRule = new NoRule();
        rule.setSuccessor(rule3);
        rule3.setSuccessor(rule5);
        rule5.setSuccessor(noRule);
    }

    private String print(int n){
        return rule.print(n);
    }


    public List<String> printList(int from, int to){
        List<String> res = new ArrayList<>();
        for(int i=from; i<=to; i++){
            res.add(print(i));
        }
        return res;
    }

}
