package com.shield.proxy.jdk;

import cn.hutool.core.util.ClassLoaderUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
public class JDKProxy {
    public static <T> T getProxy(T t) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(t);
        ClassLoader classLoader = ClassLoaderUtil.getClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, t.getClass().getInterfaces(), handler);
        return result;
    }
}
