package top.soft.classoa.service;

import top.soft.classoa.entity.User;
import top.soft.classoa.mapper.UserMapper;
import top.soft.classoa.utils.Md5Utils;

import javax.security.auth.login.LoginException;

/**
 * @author Hazel
 * @description: 用户服务类
 * @date 2024/11/30 15:06
 */
public class UserService {
    private final UserMapper userMapper = new UserMapper();

    public User login(String username, String password) throws LoginException {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new LoginException("用户名不存在");
        }
        String md5Password = Md5Utils.md5Digest(password, user.getSalt());
        if (!md5Password.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }
}
