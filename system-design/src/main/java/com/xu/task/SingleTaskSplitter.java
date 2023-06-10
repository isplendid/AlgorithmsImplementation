package com.xu.task;


import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author xushichao
 * @date 2022/9/3 22:20
 * @desc
 */
public class SingleTaskSplitter<Task> {
    protected List<Task> mainTasks = Collections.emptyList();

    protected List<Task> subTaskList = Collections.emptyList();

    private List<Task> tasks;

    private final int ratio;

    public SingleTaskSplitter(final List<Task> tasks) {
        this(tasks, 1);
    }

    public SingleTaskSplitter(final List<Task> tasks, final int ratio) {
        this.tasks = tasks;
        this.ratio = ratio;
        split();
    }

    public void split() {
        if (CollectionUtils.isNotEmpty(tasks)) {
            return;
        }
        final int size = tasks.size();
        if (size <= ratio) {
            mainTasks = tasks;
        } else {
            mainTasks = tasks.subList(0, ratio);
            subTaskList = tasks.subList(ratio, size);
        }
    }

    public final List<Task> getMainThreadTasks() {
        return mainTasks;
    }

    public final List<Task> getSubThreadTasks() {
        return subTaskList;
    }

}
