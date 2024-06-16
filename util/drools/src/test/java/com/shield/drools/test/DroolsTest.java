package com.shield.drools.test;

import cn.hutool.json.JSONUtil;
import com.shield.drools.Policy;
import com.shield.drools.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
public class DroolsTest {
    private KieContainer kieContainer;
    private Policy policy;

    @BeforeEach
    public void init() {
        // 构建KieServices
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();

        policy = new Policy();
        policy.setSex("男");
        policy.setAge(16);
        policy.setUserSingle(false);
        policy.setUserMarry(false);
        policy.setUserParenting(false);
        System.out.println("决策请求：" + JSONUtil.toJsonStr(policy));
    }

    @Test
    public void test_drools() {
        KieSession kieSession = kieContainer.newKieSession("all-rules");
        kieSession.insert(policy);
        Result result = new Result();
        kieSession.setGlobal("res", result);
        int count = kieSession.fireAllRules();

        System.out.println("Fire rule(s)：" + count);
        System.out.println("决策结果(Drools)：" + result);

        kieSession.dispose();
    }
}
