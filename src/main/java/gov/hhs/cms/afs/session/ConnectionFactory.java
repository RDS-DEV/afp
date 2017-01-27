package gov.hhs.cms.afs.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.context.annotation.Bean;

import java.io.Reader;

public class ConnectionFactory {

    private static Reader configReader;
    private static SqlSessionFactory aesSqlSessionFactory;
    private static SqlSessionFactory cpsSqlSessionFactory;

    static{
        try{

            configReader = Resources.getResourceAsReader("afs/configuration.xml");
            aesSqlSessionFactory = new SqlSessionFactoryBuilder().build(configReader, "aes");

            // The method SqlSessionFactoryBuilder.build(Reader, String) closes the Reader instance
            // before returning the SqlSessionFactory instance. That's why I'm opening a new one here.
            // There may be a better way to do this, but time is short so I gotta move on.
            configReader = Resources.getResourceAsReader("afs/configuration.xml");
            cpsSqlSessionFactory = new SqlSessionFactoryBuilder().build(configReader, "cps");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getAesSqlSessionFactory() {
        return aesSqlSessionFactory;
    }

    public static SqlSession getAesSqlSession() {
        return aesSqlSessionFactory.openSession();
    }

    public static SqlSessionFactory getCpsSqlSessionFactory() {
        return cpsSqlSessionFactory;
    }

    public static SqlSession getCpsSqlSession() {
        return cpsSqlSessionFactory.openSession();
    }

}