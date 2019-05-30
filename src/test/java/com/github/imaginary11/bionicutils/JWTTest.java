package com.github.imaginary11.bionicutils;

import com.alibaba.fastjson.JSONObject;
import com.github.imaginary11.bionicutils.jwt.JwtHelper;
import com.github.imaginary11.bionicutils.model.ReturnData;
import com.github.imaginary11.bionicutils.utils.ReflectUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/2/21 17:59
 */
public class JWTTest {
    @Test
    public void testJwt() {
        String name = "imaginary";
        JSONObject payload = new JSONObject();
        payload.put("name",name);
        String token = JwtHelper.creatToken(payload);
        Assert.assertNotNull(token);
        ReturnData returnData = JwtHelper.valid(token);
        Assert.assertEquals(name, ReflectUtil.getStrValue(returnData.getData(),"name"));
        Assert.assertTrue(returnData.getData() instanceof JSONObject);
    }
}
