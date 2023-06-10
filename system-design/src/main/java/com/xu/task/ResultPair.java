package com.xu.task;

/**
 * @author xushichao
 * @date 2022/9/5 10:30
 * @desc
 */
public class ResultPair<Task, Result> {
    public final Task task;
    public final Result result;
    public  ResultPair(Task task, Result result){
        this.task = task;
        this.result = result;
    }
}
