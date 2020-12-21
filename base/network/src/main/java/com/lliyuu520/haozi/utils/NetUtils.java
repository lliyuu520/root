package com.lliyuu520.haozi.utils;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author lliyuu520
 * @date 2020/9/1721:07
 */
@Slf4j
public class NetUtils {

    /**
     * 测试本机端口是否被使用
     *
     * @param port
     * @return
     */
    public static boolean isLocalPortUsing(int port) {
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
    public static boolean isPortUsing(String host, int port) {
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
    public static int getAvailablePort() {
        int max = 9999;
        int min = 8000;
        int port = RandomUtil.randomInt(min, max);
        boolean using = NetUtils.isLocalPortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }
}
