package com.xu;

import com.xu.job.HelloJob;
import com.xu.job.JobStatus;
import com.xu.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @author alex xu
 * @date 2025/1/23
 * @desc
 */
public class Main {


    public static void main(String[] args) throws SchedulerException {
        //1、调度器-从工厂获取调度器实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2、任务实例-执行的任务对象
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        //3、触发器-控制执行次数和执行时间
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow() //立即启动
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .withRepeatCount(10))
                .build();

        //调度器关联触发器, 并启动
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

    }



    public static void mai2n(String[] args) throws SchedulerException, InterruptedException {
        //1.创建调度器Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        //2.创建JobDetail实例， 并于MyJob绑定（Job执行内容）
        JobDetail job = JobBuilder.newJob(JobStatus.class)
                .withIdentity("statusJob", "group1")
                .usingJobData("count", 1L)
                .build();


        //3.构建Trigger实例，每隔30s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        //4.执行，开启调度器
        scheduler.scheduleJob(job,trigger);
        System.out.println(System.currentTimeMillis());

        scheduler.start();

        //主线程睡眠1min, 然后关闭调度器
        TimeUnit.SECONDS.sleep(10);
        scheduler.shutdown();
        System.out.println(System.currentTimeMillis());

    }
    public static void main1(String[] args) throws SchedulerException, InterruptedException {
        //1.创建调度器Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        //2.创建JobDetail实例， 并于MyJob绑定（Job执行内容）
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        //3.构建Trigger实例，每隔30s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(30)
                        .repeatForever())
                .build();

        //4.执行，开启调度器
        scheduler.scheduleJob(job,trigger);
        System.out.println(System.currentTimeMillis());

        scheduler.start();

        //主线程睡眠1min, 然后关闭调度器
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println(System.currentTimeMillis());

    }
}