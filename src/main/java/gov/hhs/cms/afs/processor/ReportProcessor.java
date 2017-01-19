package gov.hhs.cms.afs.processor;

/**
 * Created by Monica.Vadlapudi on 1/18/2017.
 */
import gov.AfsApp;
import org.springframework.batch.item.ItemProcessor;


import java.util.List;

public class ReportProcessor implements ItemProcessor<AfsApp, AfsApp>   {

    public  AfsApp process(AfsApp afsApp) throws Exception {
        afsApp.runReportExample();
        return null;

    }
}





