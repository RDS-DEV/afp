package gov.hhs.cms.afs.processor;

/**
 * Created by Monica.Vadlapudi on 1/18/2017.
 */
import org.springframework.batch.item.ItemProcessor;

public class ReportProcessor implements ItemProcessor<AfsApp, AfsApp>   {

    public  AfsApp process(AfsApp afsApp) throws Exception {
       // afsApp.runReportExample();
        return null;

    }
}





