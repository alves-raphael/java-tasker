# Requirements
Java (JDK) version used:
java 21.0.3 2024-04-16 LTS
Java(TM) SE Runtime Environment (build 21.0.3+7-LTS-152)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.3+7-LTS-152, mixed mode, sharing)

## Recommendations of use
With the intellij IDEA opened, click with right button in the root folder of the project, go to "maven" options and select the "Reload project" options, in order to download the dependencies
## Task Manager
Clone this repository and open in the intellij IDEA. Run the main method in the TaskManager class.
## Cron Scheduler
Run the CronScheduler main method to run the cron that writes in the events.json file every hour (Tip: change the `0 0 * * *` to `0 * * * *` to run every minute)