package top.soft.bookonline.service.impl;

import top.soft.bookonline.entity.User;

public interface UserService<user> {
    /**
     * @param account
     * @param password
     * @return user
     */
    user singIn(String account, String password);


    User signIn(String account, String password);



}