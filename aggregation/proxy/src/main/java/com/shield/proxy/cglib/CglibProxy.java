package com.shield.proxy.cglib;

import cn.hutool.core.lang.Console;
import com.shield.proxy.service.impl.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Console.log("我被CglibProxy代理了");
        return methodProxy.invokeSuper(o, objects);
    }

    public Object newInstall(Object object) {
        return Enhancer.create(object.getClass(), this);
    }
}
