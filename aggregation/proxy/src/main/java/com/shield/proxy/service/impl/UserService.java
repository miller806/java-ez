package com.shield.proxy.service.impl;

import com.shield.proxy.service.IUserService;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
public class UserService implements IUserService {

    @Override
    public String queryUserNameById(String userId) {
        return "hi user " + userId;
    }
}
