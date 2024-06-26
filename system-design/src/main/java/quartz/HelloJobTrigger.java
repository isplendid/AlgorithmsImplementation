package quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution
public class HelloJobTrigger  implements Job {



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取当前时间,并格式化
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateSrting = format.format(date);

        // 业务功能模拟
        System.out.println("---------------------------------------------------");
        System.out.println("开始备份数据库,时间：" + dateSrting);

        // 获取 JobKey,StartTime,EndTime
        System.out.println("JobKey ： " + context.getTrigger().getJobKey());
        System.out.println("StartTime ： " + format.format(context.getTrigger().getStartTime()));
        System.out.println("EndTime ： " + format.format(context.getTrigger().getEndTime()));
        System.out.println("---------------------------------------------------");
    }

}
