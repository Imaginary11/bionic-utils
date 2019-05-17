package com.github.imaginary11.bionicutils.utils;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;


/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2018/9/20 16:09
 */
public class AESUtil {
    public static final String DEFAULT_ENCODE_RULE = "cn.com.imaginary";
    private static final String AES = "AES";
    private static final String UTF8 = "utf-8";

    /**
     * 加密
     * <P>1.构造密钥生成器
     * <P>2.根据ecnodeRules规则初始化密钥生成器
     * <P>3.产生密钥
     * <P>4.创建和初始化密码器
     * <P>5.内容加密
     * <P>6.返回字符串
     *
     * @param encodeRules 加密规则
     * @param content     加密内容
     * @return 加密后的字符串
     * @throws Exception a case of encode exception
     */
    public static String encode(String encodeRules, String content) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(AES);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(encodeRules.getBytes());
        keygen.init(128, secureRandom);
        SecretKey original_key = keygen.generateKey();
        byte[] raw = original_key.getEncoded();
        SecretKey key = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] byte_encode = content.getBytes(StandardCharsets.UTF_8);
        byte[] byte_AES = cipher.doFinal(byte_encode);
        return Base64.getEncoder().encodeToString(byte_AES);
    }

    /**
     * 解密
     * <p>解密过程：
     * <p>1.同加密1-4步
     * <p>2.将加密后的字符串反纺成byte[]数组
     * <p>3.将加密内容解密
     *
     * @param encodeRules 解密规则
     * @param content     解密内容
     * @return 解密后的原始字符串
     * @throws Exception a case of encode exception
     */
    public static String decode(String encodeRules, String content) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(AES);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(encodeRules.getBytes());
        keygen.init(128, secureRandom);
        SecretKey original_key = keygen.generateKey();
        byte[] raw = original_key.getEncoded();
        SecretKey key = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] byte_content = Base64.getDecoder().decode(content);
        // 解密
        byte[] byte_decode = cipher.doFinal(byte_content);
        String AES_decode = new String(byte_decode, StandardCharsets.UTF_8);
        return AES_decode;
    }

}