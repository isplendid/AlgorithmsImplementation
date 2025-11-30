Quartz 的核心类有以下三部分：

任务 Job ： 需要实现的任务类，实现 execute() 方法，执行后完成任务。
触发器 Trigger ： 包括 SimpleTrigger 和 CronTrigger。
调度器 Scheduler ： 任务调度器，负责基于 Trigger触发器，来执行 Job任务。


