package com.demo;

import com.demo.user.bo.UserBO;
import com.demo.user.vo.UserVO;
import com.levelup.domain.Agency;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by jarsen on 1/10/17.
 */
public class DemoApp {

    public static void main(String args[])throws Exception{

        UserBO bo = new UserBO();
        UserVO vo= new UserVO();

        vo.setId(1);
        vo.setAddress("Test Address");
        vo.setEmail("test_email@gmail.com");
        vo.setFullName("Test User");
        vo.setMobile("12411515");

        System.out.println("\nUser to be created:\n" + vo);
        bo.createUser(vo);
        System.out.println("\nCreated user record from database:\n" + bo.getUsers());

        vo = bo.getUserById(1);
        vo.setAddress("Updates Test Address");
        vo.setEmail("updated_test_email@gmail.com");
        vo.setFullName("Updated Test User");
        vo.setMobile("1241151511");

        System.out.println("\n\nUser info to be updated:\n" + vo);
        bo.updateUser(vo);
        vo=bo.getUserById(1);
        System.out.println("\nUpdated user record from database:\n" + vo);

        System.out.println("\n\nDeleting user with id = 1 from database");
        bo.deleteUser(vo);
        System.out.println("List of current users in database:" + bo.getUsers());

        getOneAgency(10);

    }

    private static void getOneAgency(int agency_id) {

        SqlSession session = ConnectionFactory.getAgencySession().openSession();

        System.out.println("\n\nSelectOneAgency: id = 10");
        Agency agency = session.selectOne("selectAgency", 10);
        System.out.println(agency);

    }
}
