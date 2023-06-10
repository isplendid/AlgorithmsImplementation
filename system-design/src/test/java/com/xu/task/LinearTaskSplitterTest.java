package com.xu.task;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xushichao
 * @date 2022/9/5 15:08
 * @desc
 */
public class LinearTaskSplitterTest {


    @Test
    public void getSubThreadTasks() throws Exception {

        List<Integer> tasks = new ArrayList<>(2000);
        int count = new Random().nextInt(2000);
        int cnt = 20;

        for (int i = 0; i < cnt; ++i) {
            tasks.add(i);
        }

//        LinearTaskSplitter<Integer> splitor = new LinearTaskSplitter<>(tasks, 1, 1);
//        Assert.assertEquals(getTaskItems(splitor), tasks);

        LinearTaskSplitter<Integer> splitor2 = new LinearTaskSplitter<>(tasks, 2, 5);
        System.out.println("main:"+splitor2.getMainThreadTask().size());
        System.out.println("sub:"+ splitor2.getSubThreadTasks().size());

    }

    private List<Integer> getTaskItems(LinearTaskSplitter<Integer> splitor) {
        List<Integer> items = new ArrayList<>(splitor.getMainThreadTask());
        for (List<Integer> objects : splitor.getSubThreadTasks()) {
            items.addAll(objects);
        }
        return items;
    }
}
