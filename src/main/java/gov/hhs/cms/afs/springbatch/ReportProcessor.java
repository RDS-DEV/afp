package gov.hhs.cms.afs.springbatch;

import org.springframework.batch.item.ItemProcessor;
import com.levelup.AfsApp;
/**
 * Created by Monica.Vadlapudi on 1/18/2017.
 */


public class ReportProcessor implements ItemProcessor<AfsApp, AfsApp> {

    public AfsApp process(AfsApp afsApp) throws Exception {
        // afsApp.runReportExample();
        return null;

    }
}