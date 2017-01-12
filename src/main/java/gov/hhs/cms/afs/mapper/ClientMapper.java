package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Client;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public interface ClientMapper {

    @Results({
            @Result(property = "id", column = "client_id"),
            @Result(property = "name", column = "client_name"),
            @Result(property = "phone", column = "client_phone"),
            @Result(property = "city", column = "client_city"),
            @Result(property = "state", column = "client_state")
    })
    @Select("select * from client where client_id = #{id}")
    Client getClientById(int clientId);

    // There may be a way to assign an id to the results declaration
    // and then reuse them just by giving the id. Maybe in v.3.4.3?
    @Results({
            @Result(property = "id", column = "client_id"),
            @Result(property = "name", column = "client_name"),
            @Result(property = "phone", column = "client_phone"),
            @Result(property = "city", column = "client_city"),
            @Result(property = "state", column = "client_state")
    })
    @Select("select * from client")
    List<Client> getAllClients();

}
