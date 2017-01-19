package gov.hhs.cms.afs.jobListener;

import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.util.List;

/**
 * Created by Monica.Vadlapudi on 1/18/2017.
 */
public class ReportJobListener implements JobExecutionListener {
    private DateTime startTime, stopTime;


    public void beforeJob(JobExecution jobExecution){
        startTime = new DateTime();
        System.out.println("Report Job Starts at :" +startTime);
    }


    public void afterJob(JobExecution jobExecution) {
        stopTime = new DateTime();
        System.out.println("Report Job ends at :" + getTimeInMillis(startTime, stopTime));

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("Report job completed successfully");
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            System.out.println("Report job failed with following Exceptions");
            List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
            for (Throwable th : exceptionList) {
                System.err.println("exception :" + th.getLocalizedMessage());
            }
        }
    }
    private long getTimeInMillis(DateTime start, DateTime stop){
        return stop.getMillis() - start.getMillis();
    }

}
