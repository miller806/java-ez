package com.shield.liteflow.cmp;

import cn.hutool.core.lang.Console;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @author miller
 * @date 2023/9/23
 * @version 1.0.0
 */
@Component("c")
public class CCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        Console.log("c");
    }
}
