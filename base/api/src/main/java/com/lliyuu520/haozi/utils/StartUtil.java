package com.lliyuu520.haozi.utils;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 使用随机端口启动
 *
 * @author lliyuu520
 * @date 2020/9/1721:09
 */
@Slf4j
public class StartUtil {
    public StartUtil(String[] args) {
        Boolean isServerPort = false;
        String serverPort = "";
        if (args != null) {
            for (String arg : args) {
                if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
                    isServerPort = true;
                    serverPort = arg;
                    break;
                }
            }
        }

        //没有指定端口，则随机生成一个可用的端口
        if (!isServerPort) {
            int port = getAvailablePort();
            log.info("使用随机端口启动:" + port);
            System.setProperty("server.port", String.valueOf(port));
        } else {//指定了端口，则以指定的端口为准
            log.info("使用指定端口启动" + serverPort.split("=")[1]);
            System.setProperty("server.port", serverPort.split("=")[1]);
        }
    }


    /**
     * 测试本机端口是否被使用
     *
     * @param port
     * @return
     */
    private static boolean isLocalPortUsing(int port) {
        boolean flag = true;
        try {
            //如果该端口还在使用则返回true,否则返回false,127.0.0.1代表本机
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        }
        return flag;
    }

    /***
     * 测试主机Host的port端口是否被使用
     * @param host
     * @param port
     * @throws
     */
    private static boolean isPortUsing(String host, int port) {
        boolean flag = false;
        try {
            InetAddress Address = InetAddress.getByName(host);
            new Socket(Address, port);
            flag = true;
        } catch (IOException e) {
        }
        return flag;
    }


    /**
     * 获取可用端口
     *
     * @return
     */
    private static int getAvailablePort() {
        int max = 29999;
        int min = 20000;
        int port = RandomUtil.randomInt(min, max);
        boolean using = isLocalPortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }

}
