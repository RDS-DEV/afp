package com.mybatis.demo.user.bo;

import com.mybatis.demo.ConnectionFactory;
import com.mybatis.demo.user.dao.UserDAO;
import com.mybatis.demo.user.vo.UserVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserBO {

    public List<UserVO> getUsers() throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserDAO dao =session.getMapper(UserDAO.class);
        List<UserVO> users= dao.getAllUsers();
        session.close();
        return users;
    }
    public UserVO getUserById(long id) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserDAO dao =session.getMapper(UserDAO.class);
        UserVO user =dao.getUserById(id);
        session.close();
        return user;
    }
    public UserVO createUser(UserVO vo) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserDAO dao =session.getMapper(UserDAO.class);
        dao.doCreateUser(vo);
        session.commit();
        session.close();
        return vo;
    }
    public UserVO updateUser(UserVO vo) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserDAO dao =session.getMapper(UserDAO.class);
        dao.doUpdateUser(vo);
        session.commit();
        session.close();
        return vo;
    }
    public int deleteUser(UserVO vo) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserDAO dao =session.getMapper(UserDAO.class);
        int cnt= dao.doDeleteUser(vo);
        session.commit();
        session.close();
        return cnt;
    }

    public static void main(String a[])throws Exception{

        UserBO bo = new UserBO();
        UserVO vo= new UserVO();

        vo.setAddress("Test");
        vo.setEmail("test@gmail.com");
        vo.setFullName("Full Name");
        vo.setMobile("12411515");

        System.out.println("\nUser to be created:\n" + vo);
        bo.createUser(vo);
        System.out.println("\nCreated user record from database:\n" + bo.getUsers());

        vo = bo.getUserById(1);
        vo.setAddress("Test Updated Address");
        vo.setEmail("testupdated@gmail.com");
        vo.setFullName("Full Name Test");
        vo.setMobile("1241151511");

        System.out.println("\n\nUser info to be updated:\n" + vo);
        bo.updateUser(vo);
        vo=bo.getUserById(1);
        System.out.println("\nUpdated user record from database:\n" + vo);

        System.out.println("\n\nDeleting user with id = 1 from database");
        bo.deleteUser(vo);
        System.out.println("List of current users in database:" + bo.getUsers());

        System.out.println("\n\nNOTE:\nYou have to manually reset the database to rerun these tests.");
        System.out.println("\tDelete any user records remaining in the users table.");
        System.out.println("\tReset AUTO_INCREMENT count to 1:");
        System.out.println("\t\tALTER TABLE users AUTO_INCREMENT = 1;");

    }
}
