package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

class UserDaoTest {
    @Test
    void insertUser(){   String url = "jdbc:mysql://localhost:3306/your_database?useSSL=false&allowPublicKeyRetrieval=true";

        UserDao userdao = new UserDaoImpl();
        User user= User.builder()
                .account("zch")
                .nickname("zch").password("123456").address("江苏南京").avatar("m.png").build();
        userdao.insertUser(user);
    }



}