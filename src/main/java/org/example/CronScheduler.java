package org.example;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronScheduler {

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(GraphQLQueryJob.class)
                .withIdentity("graphqlJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * * ?"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
