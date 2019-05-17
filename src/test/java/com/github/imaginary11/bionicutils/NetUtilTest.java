package com.github.imaginary11.bionicutils;

import com.github.imaginary11.bionicutils.utils.NetUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/3/5 11:36
 */
public class NetUtilTest {
    @Test
    public void testPing() {
        String[] ipAddress = new String[]{"baidu.com", "sina.com"};
        Assert.assertNotNull(NetUtil.getOneUseFullIp(ipAddress));
    }
}
