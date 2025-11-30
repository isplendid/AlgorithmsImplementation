package com.xu.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author alex xu
 * @date 2025/11/2
 * @desc   功能描述： 任务
 */
public class HelloJob  implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取当前时间,并格式化
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        // 业务功能模拟
        System.out.println("开始备份数据库,时间：" + dateString);
    }
}
