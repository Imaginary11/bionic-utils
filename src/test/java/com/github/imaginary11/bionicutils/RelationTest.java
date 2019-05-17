package com.github.imaginary11.bionicutils;

import com.alibaba.fastjson.JSONObject;
import com.github.imaginary11.bionicutils.utils.RelationUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/3/6 18:18
 */
public class RelationTest {
    @Test
    public void testBuildTree() {
        List<JSONObject> list = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("pid", 3);
        data.put("name", "cc");
        data.put("id", 4);

        JSONObject data1 = new JSONObject();
        data1.put("pid", 1);
        data1.put("name", "abc");
        data1.put("id", 3);

        list.add(data);
        list.add(data1);

        List<JSONObject> result = RelationUtil.buildTree(list, "childs");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(1, result.get(0).get("pid"));

    }
}
