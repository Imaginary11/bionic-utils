package com.github.imaginary11.bionicutils.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.imaginary11.bionicutils.comparator.ListObjectComparator;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2018/10/12 16:25
 */
public class RelationUtil {

    public static List<JSONObject> buildTree(List list, String childName) {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<JSONObject>> pidMap = new HashMap<>();
        for (Object obj : list) {
            JSONObject object = (JSONObject) JSONObject.toJSON(obj);
            List<JSONObject> subList = pidMap.get(ReflectUtil.getIntValue(object, "pid"));
            if (subList == null) {
                subList = new ArrayList<>();
            }
            subList.add(object);
            pidMap.put(ReflectUtil.getIntValue(object, "pid"), subList);
        }

        Integer rootId = 0;
        Set<Integer> ids = pidMap.keySet();
        if (ids.size() > 0) {
            List<Integer> idsList = new ArrayList<>();
            ids.forEach(p -> idsList.add(p));
            Collections.sort(idsList);
            rootId = idsList.get(0);
        }

        return doBuldTree(pidMap.get(rootId), pidMap, childName);
    }

    private static List<JSONObject> doBuldTree(List<JSONObject> childs, Map<Integer, List<JSONObject>> pidMap, String childName) {
        String name = StringUtils.isEmpty(childName) ? "childs" : childName;
        for (JSONObject obj : childs) {
            if (pidMap.get(ReflectUtil.getIntValue(obj, "id")) != null) {
                List<JSONObject> list = pidMap.get(ReflectUtil.getIntValue(obj, "id"));
                Collections.sort(list, new ListObjectComparator("id", "Integer"));
                obj.put(name, list);
                doBuldTree(list, pidMap, childName);
            }
        }
        return childs;
    }
}
