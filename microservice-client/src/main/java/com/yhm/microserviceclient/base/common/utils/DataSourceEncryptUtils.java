package com.yhm.microserviceclient.base.common.utils;

import com.alibaba.druid.filter.config.ConfigTools;

public class DataSourceEncryptUtils {

    public static void main(String[] args) throws Exception {
        ConfigTools c = new ConfigTools();
        String password = "ZB35infor89";
        String[] arr = c.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + c.encrypt(arr[0], password));
    }
}
