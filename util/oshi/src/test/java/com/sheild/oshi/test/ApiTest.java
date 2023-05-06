package com.sheild.oshi.test;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 * @author miller
 * @version 1.0.0
 * @date 2023/5/6
 */
public class ApiTest {
    @Test
    void test() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem operatingSystem = si.getOperatingSystem();
        Console.log("硬件信息:{}", hal.getComputerSystem());
        Console.log("操作系统信息:{}", operatingSystem);
        CentralProcessor cpu = hal.getProcessor();
    }
}
