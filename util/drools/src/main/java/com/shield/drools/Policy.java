package com.shield.drools;

import lombok.Data;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
@Data
public class Policy {
    private String sex;            // 性别；男、女
    private Integer age;           // 年龄
    private Boolean userSingle;    // 单身；是/否
    private Boolean userMarry;     // 结婚；是/否
    private Boolean userParenting; // 育儿；是/否
}
