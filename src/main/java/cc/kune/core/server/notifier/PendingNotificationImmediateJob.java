package cc.kune.core.server.notifier;

import java.text.ParseException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.google.inject.Inject;

public class PendingNotificationImmediateJob implements Job {

  public static final Log LOG = LogFactory.getLog(PendingNotificationImmediateJob.class);

  private final PendingNotificationSender pendingManager;

  @Inject
  public PendingNotificationImmediateJob(final PendingNotificationSender pendingManager)
      throws ParseException, SchedulerException {
    this.pendingManager = pendingManager;
  }

  @Override
  public void execute(final JobExecutionContext context) throws JobExecutionException {
    LOG.info(String.format("Immediate notifications cron job start, %s", pendingManager));
    pendingManager.sendImmediateNotifications();
    LOG.info(String.format("Immediate notifications cron job end, %s", pendingManager));
  }

}
