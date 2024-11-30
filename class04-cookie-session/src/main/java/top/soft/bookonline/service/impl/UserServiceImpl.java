package top.soft.bookonline.service.impl;

import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

/**
 * @author 11448
 * @description: TODO
 * @date 2024/10/26 14:16
 */

public class UserServiceImpl implements UserService {
    @Override
    public Object singIn(String account, String password) {
        return null;
    }

    private final UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录功能
     *
     * @param account  账号
     * @param password 密码
     * @return user
     */
    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }


}
