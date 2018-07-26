package com.dadagum;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class PasswdDecodeTest {

    @Test
    public void printDecodedPasswd(){
        String simpleHash = new SimpleHash("md5", "test", "test", 1).toString();
        System.out.println(simpleHash);
    }

    @Test
    public void generateRandomSalt(){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        System.out.println(salt);
    }
}
