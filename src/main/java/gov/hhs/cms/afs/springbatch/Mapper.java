package gov.hhs.cms.afs.springbatch;

/**
 * Created by Monica.Vadlapudi on 1/25/2017.
 */
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import org.joda.time.LocalDate;
        import org.springframework.jdbc.core.RowMapper;
        import gov.hhs.cms.afs.domain.Agency;
        import gov.hhs.cms.afs.domain.Client;
        import gov.hhs.cms.afs.domain.Employee;
        import gov.hhs.cms.afs.domain.Policy;

public class Mapper implements RowMapper<AppResultTasklet>{


    public AppResultTasklet mapRow(ResultSet rs, int rowNum) throws SQLException {

        AppResultTasklet report = new AppResultTasklet();
        return report;
    }
}
