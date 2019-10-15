package com.dandelion.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * ClassName: EncryptionUtil
 * date:      2019/10/15 10:49
 * author:    puyiliang
 * description:加密解密 工具类
 */
public class EncryptionUtil {
    /**
     * 获取加密后的密码
     * @param hashAlgorithm   hash算法名称 MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512、etc。
     * @param password        需要加密的密码
     * @param salt            盐
     * @param hashIterations  Hash迭代次数
     * @return 加密后的密码
     */
    public static String encryptPassword(String hashAlgorithm, String password, ByteSource salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
        return hash.toString();
    }

    public static void main(String[] args) {
        ByteSource salt = ByteSource.Util.bytes("admin");
        String md5 = encryptPassword("MD5", "000000", salt, 3);
        System.out.println(md5);
    }
}
