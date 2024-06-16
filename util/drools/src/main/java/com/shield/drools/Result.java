package com.shield.drools;

import lombok.Data;

/**
 * @author miller
 * @date 2023/9/22
 * @version 1.0.0
 */
@Data
public class Result {
    private String code;
    private String info;

    public void setResult(String code, String info) {
        this.setCode(code);
        this.setInfo(info);
    }
}
