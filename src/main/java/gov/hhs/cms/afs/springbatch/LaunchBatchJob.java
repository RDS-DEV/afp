package gov.hhs.cms.afs.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by jwleader on 9/29/15.
 */


public class LaunchBatchJob {
    private static String CLASS_NAME = LaunchBatchJob.class.getName();

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {


        String[] springConfig =
                {
                        "spring/batch/config/job-hello-world.xml"
                };


        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = (Job) context.getBean("examResultJob");

        // Create Job Parameter(s)
        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Exit Status : "+ execution.getStatus());

        } catch (JobExecutionException e) {
            System.out.println("Job ExamResult failed");
            e.printStackTrace();
        }


    }
}