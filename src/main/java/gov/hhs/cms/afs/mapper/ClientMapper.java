package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Client;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public interface ClientMapper {

    @Select("select client_id as id, client_name as NAME from CLIENT where client_id = #{id}")
    Client getClientById(int clientId);

    @Select("select client_id as id, client_name as NAME from CLIENT")
    List<Client> getAllClients();

}
