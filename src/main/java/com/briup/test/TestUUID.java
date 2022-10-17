package com.briup.test;

import java.util.UUID;

/**
 * @Author lining
 * @Date 2022/10/17
 */
public class TestUUID {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String msg = uuid.toString();
        System.out.println(msg);
    }
}
