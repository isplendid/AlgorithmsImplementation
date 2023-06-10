package task.scheduler;

/**
 * @author xushichao
 * @date 2023/5/22 21:58
 * @desc
 * 要求implement a delay scheduler这道题，就是给一个任务和指定的delay时间，
 * 要求把task schedule在指定的时间执行，比如schedule method长这样：Future schedule(int delay_time, Runnable task)。
 *
 * 这个题目其实是一个大坑，需要好好做一下。
 * PriorityBlockingQueue + polling, 是大家最容易想到的方案，然而轮询通常有个很大的缺点，就是时间间隔不好设置，间隔太长，任务无法及时处理，间隔太短，会很耗CPU。
 * 比较好的两个方案是 DelayQueue 和 HashedWheelTimer https://soulmachine.gitbooks.io/system-design/content/cn/task-scheduler.html
 */
public class DesignDelayScheduler {


}
