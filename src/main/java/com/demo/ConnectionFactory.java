package com.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class ConnectionFactory {

    private static SqlSessionFactory sqlMapper;
    private static Reader reader;

    private static SqlSessionFactory aesMapper;
    private static Reader aesReader;

    static{
        try{
            reader	  = Resources.getResourceAsReader("demo/configuration.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            aesReader = Resources.getResourceAsReader("mybatis-config.xml");
            aesMapper = new SqlSessionFactoryBuilder().build(aesReader);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlMapper;
    }

    public static SqlSessionFactory getAgencySession() {return aesMapper; }

}