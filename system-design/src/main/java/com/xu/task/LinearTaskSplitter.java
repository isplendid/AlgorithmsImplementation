package com.xu.task;




import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xushichao
 * @date 2022/9/5 15:04
 * @desc
 */
public  class LinearTaskSplitter<Task> {
    private List<Task> mainTasks = Collections.emptyList();

    private List<List<Task>> subTasksList = Collections.emptyList();

    private final List<Task> tasks;

    /***
     * ratio为分给主线程的页数
     */
    private int ratio = 2;

    private int pieceSize = 50;


    public LinearTaskSplitter(final List<Task> tasks) {
        this(tasks, 2, 50);
    }

    public LinearTaskSplitter(List<Task> tasks, int ratio, int pieceSize) {
        this.tasks = tasks;
        this.ratio = ratio;
        this.pieceSize = pieceSize;
        split();
    }

    private  void split(){
        if(CollectionUtils.isEmpty(tasks)){
            return;
        }

        final int size = tasks.size();
        if (size < ratio * pieceSize) {
            mainTasks = tasks;
        } else {
            //计算总页数
            final int count = size % pieceSize == 0 ? size / pieceSize : (size / pieceSize) + 1;
            //[0, ratio)页给mainTasks, [ratio, count)给subTasks
            subTasksList = new ArrayList<>(count - ratio);
            for (int i = ratio; i < count; ++i) {
                final int start = i * pieceSize;
                final int end = Math.min((i + 1) * pieceSize, size);
                if (size - end < pieceSize) {
                    subTasksList.add(tasks.subList(start, size));
                    break;
                } else {
                    subTasksList.add(tasks.subList(start, end));
                }
            }
            mainTasks = tasks.subList(0, ratio * pieceSize);
        }

    }

    public Task get(int i) {
        return tasks.get(i);
    }

    public int getTaskSize() {
        return tasks == null ? 0 : tasks.size();
    }

    public final List<Task> getMainThreadTask() {
        return mainTasks;
    }

    public final List<List<Task>> getSubThreadTasks() {
        return subTasksList;
    }
}
