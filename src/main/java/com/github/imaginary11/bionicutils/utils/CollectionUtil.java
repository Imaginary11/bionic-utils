package com.github.imaginary11.bionicutils.utils;


import com.github.imaginary11.bionicutils.comparator.ListObjectComparator;
import com.github.imaginary11.bionicutils.constants.StringConsts;
import com.github.imaginary11.bionicutils.enums.OrderByEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/4/9 12:26
 */
public class CollectionUtil<T> {
    /**
     * 比较连个集合元素是否相同
     *
     * @param listA
     * @param listB
     * @return
     */
    public static boolean isListEquals(List listA, List listB) {
        if (listA == null && listB == null) {
            return true;
        }
        if (listA == null && listB != null) {
            return false;
        }
        if (listB == null && listA != null) {
            return false;
        }
        if (listA.size() == listB.size()) {
            if (listA.size() == 0) {
                return true;
            }

            for (Object temp : listA) {
                if (!listB.contains(temp)) {
                    return false;
                }
            }
            return true;
        }


        return false;
    }


    /**
     * parse 1,2,3,4 to [1,2,3,4,5]
     */
    public static <T> List parseStr2List(String listStr, Class<T> tClass) {
        if (StringUtil.isEmpty(listStr)) {
            return new ArrayList();
        }
        if (tClass == String.class) {
            List<String> idsStr = new ArrayList<>();
            if (listStr.contains(StringConsts.COMMA)) {
                String[] arr = listStr.split(StringConsts.COMMA);
                for (int i = 0; i < arr.length; i++) {
                    idsStr.add(arr[i]);
                }
            } else {
                idsStr.add(listStr);
            }
            return idsStr;
        } else if (tClass == Integer.class) {
            List<Integer> idsStr = new ArrayList<>();
            if (listStr.contains(StringConsts.COMMA)) {
                String[] arr = listStr.split(StringConsts.COMMA);
                for (int i = 0; i < arr.length; i++) {
                    idsStr.add(Integer.parseInt(arr[i]));
                }
            } else {
                idsStr.add(Integer.parseInt(listStr));
            }
            return idsStr;
        } else {
            return null;
        }
    }


    /**
     * 列表对象排序
     */
    public static <T> List sortObjList(List list, String objKey, Class<T> keyType, OrderByEnums orderByEnums) {
        String keyTypeString = "";
        if (keyType == String.class) {
            keyTypeString = "String";
        } else if (keyType == Integer.class) {
            keyTypeString = "Integer";
        }
        Collections.sort(list, new ListObjectComparator(objKey, keyTypeString, orderByEnums.getName()));
        return list;
    }

}
