package gov.hhs.cms.afs.dao;

import gov.hhs.cms.afs.domain.Client;
import gov.hhs.cms.afs.mapper.ClientMapper;
import gov.hhs.cms.afs.session.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public class ClientDAO {

    public Client getClientById(Integer clientId) {
        SqlSession session = ConnectionFactory.getCpsSqlSession();
        ClientMapper mapper = session.getMapper(ClientMapper.class);
        Client client = mapper.getClientById(clientId);
        session.close();
        return client;
    }

    public List<Client> getAllClients() {
        SqlSession session = ConnectionFactory.getCpsSqlSession();
        ClientMapper mapper = session.getMapper(ClientMapper.class);
        List<Client> clients = mapper.getAllClients();
        session.close();
        return clients;
    }


}
