package com.shield.protocol.test;

import com.shield.protocol.TransactionDTO;
import com.shield.protocol.TransactionProto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ProtobufTest {
    @Test
    void testProtobuf() {
        String transactionJson = "{\n" +
                "    \"chainId\": 195,\n" +
                "    \"tokenId\": \"195\",\n" +
                "    \"hash\": \"d3de2f5049b2df46455e76c61715311c0fa5183ec873ac74713076bd7e46f96c\",\n" +
                "    \"blockHash\": \"0000000003a3f1f0084d838ebc0048f55e9aa6dafb34177deba44de267ad507a\",\n" +
                "    \"blockNumber\": \"61075952\",\n" +
                "    \"blockTime\": \"1713870387\",\n" +
                "    \"fee\": \"0\",\n" +
                "    \"fromAddress\": \"TPAGNcyoCkdrFA6YFHUR1GrcySMHUr88jq\",\n" +
                "    \"toAddress\": \"TRhYvBXFQ12rekhX9TADx8bVSGUyzjgR8Z\",\n" +
                "    \"status\": 1,\n" +
                "    \"type\": 1,\n" +
                "    \"amount\": 14200000\n" +
                "}";
        TransactionDTO transactionDTO = new TransactionDTO();
        TransactionProto.Transaction transactionProtobuf = TransactionProto.Transaction.newBuilder()
                .setChainId(195)
                .setTokenId("195")
                .setHash("d3de2f5049b2df46455e76c61715311c0fa5183ec873ac74713076bd7e46f96c")
                .setAmount("14200000")
                .setFee("0")
                .setBlockHash("0000000003a3f1f0084d838ebc0048f55e9aa6dafb34177deba44de267ad507a")
                .setBlockTime("1713870387")
                .setBlockNumber("61075952")
                .setFromAddress("TPAGNcyoCkdrFA6YFHUR1GrcySMHUr88jq")
                .setToAddress("TRhYvBXFQ12rekhX9TADx8bVSGUyzjgR8Z")
                .setStatus("1")
                .setType(1)
                .build();
        log.info("json大小：{}",transactionJson.getBytes().length);
        log.info("protobuf大小：{}",transactionProtobuf.toByteArray().length);
    }
}
