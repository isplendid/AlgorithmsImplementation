package task.scheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2023/5/18 10:52
 * @desc 线性表调度
 */
public class TimeTaskDemo1 {
    private Map<String, Long> expireMap = new ConcurrentHashMap<>();
    private static final Long TIME_DURATION = 1000L; //每隔1s执行一次

    {
        new Thread(() -> {//taskThread通过(while-true-sleep)模拟job每隔TIME_DURATION时间，定时执行任务
            while (true) {
                long now = System.currentTimeMillis();
                for (Map.Entry<String, Long> entry : expireMap.entrySet()) {
                    if (now >= entry.getValue()) {//任务如果过期则执行任务
                        //runTask(entry.getKey());//具体执行任务的逻辑
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(TIME_DURATION);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void addTask(String taskId, Long expireTime) {//保存任务Id和过期时间的映射关系
        expireMap.put(taskId, expireTime);
    }
}

