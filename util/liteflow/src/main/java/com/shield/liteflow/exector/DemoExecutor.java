package com.shield.liteflow.exector;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author miller
 * @date 2023/9/23
 * @version 1.0.0
 */
@Component
public class DemoExecutor {
    @Resource
    FlowExecutor flowExecutor;

    @PostConstruct
    public void testConfig() {
        LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain1", "arg");
    }
}
