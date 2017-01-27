package gov.hhs.cms.afs.springbatch.model;

/**
 * Created by Monica.Vadlapudi on 1/25/2017.
 */
public class ReportData {

    private int id;
    private String report;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "ReportData{" +
                "id=" + id +
                ", report='" + report + '\'' +
                '}';
    }
}
