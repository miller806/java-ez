package com.shield.proxy.test;

import cn.hutool.core.lang.Console;
import com.shield.proxy.cglib.CglibProxy;
import com.shield.proxy.jdk.JDKProxy;
import com.shield.proxy.service.IUserService;
import com.shield.proxy.service.impl.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
public class ProxyTest {
    @Test
    void testJDK() throws Exception {
        IUserService userService = JDKProxy.getProxy(new UserService());
        String userName = userService.queryUserNameById("11111");
        Console.log(userName);
    }

    @Test
    void testCglib() {
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = (UserService) cglibProxy.newInstall(new UserService());
        String userName = userService.queryUserNameById("10001");
        System.out.println(userName);
    }
}
