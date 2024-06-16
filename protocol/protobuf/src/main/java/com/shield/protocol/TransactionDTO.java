package com.shield.protocol;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author miller
 * @version 1.0.0
 * @since 2024/3/15
 */
@Data
@Accessors(chain = true)
public class TransactionDTO {
    /**
     * 链编号
     */
    private Integer chainId;
    /**
     * token编号
     */
    private String tokenId;
    /**
     * 交易哈希
     */
    private String hash;
    /**
     * 区块哈希
     */
    private String blockHash;
    /**
     * 区块高度
     */
    private String blockNumber;
    /**
     * 区块时间
     */
    private String blockTime;
    /**
     * 手续费
     */
    private String fee;
    /**
     * 发起地址
     */
    private String fromAddress;
    /**
     * 到账地址
     */
    private String toAddress;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 索引
     */
    private Integer index;

    /**
     * 交易类型
     */
    private Integer type;

    /**
     * 交易金额
     */
    private Long amount;
}
