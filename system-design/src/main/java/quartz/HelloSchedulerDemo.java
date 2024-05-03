package quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/***
 * 定时器类
 */
public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {
        //1、调度器

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2、任务实例

        JobDetail job = JobBuilder.newJob(HelloJob2.class)
                .withIdentity("job1", "group1")
                .build();

        //3、触发器-- 控制执行次数和执行时间
        Trigger trigger =  TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(10)) // 循环10次,每次间隔3s
                .build();

        //调度器关联触发器，并启动
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

    }

}
