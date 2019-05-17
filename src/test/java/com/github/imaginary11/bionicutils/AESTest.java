package com.github.imaginary11.bionicutils;

import com.github.imaginary11.bionicutils.utils.AESUtil;
import org.junit.Assert;
import org.junit.Test;

import static com.github.imaginary11.bionicutils.utils.AESUtil.DEFAULT_ENCODE_RULE;


/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/2/22 10:04
 */
public class AESTest {
    @Test
    public void testAES(){
        try {
            String content = "hello world";
            String encodeString = AESUtil.encode(DEFAULT_ENCODE_RULE,content);
            Assert.assertNotNull(encodeString);
            String decodeString = AESUtil.decode(DEFAULT_ENCODE_RULE,encodeString);
            Assert.assertEquals(content,decodeString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
