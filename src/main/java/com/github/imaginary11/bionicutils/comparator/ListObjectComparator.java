package com.github.imaginary11.bionicutils.comparator;


import com.github.imaginary11.bionicutils.utils.ReflectUtil;

import java.text.Collator;
import java.util.Comparator;

import static com.github.imaginary11.bionicutils.enums.OrderByEnums.DESC;


/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2018/10/11 12:24
 */
public class ListObjectComparator implements Comparator<Object> {
    private Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
    private String compareStr;
    private String type;
    private String orderby;

    public ListObjectComparator() {

    }

    public ListObjectComparator(String compareStr, String type) {
        this.compareStr = compareStr;
        this.type = type;
    }

    public ListObjectComparator(String compareStr, String type, String orderby) {
        this.compareStr = compareStr;
        this.type = type;
        this.orderby = orderby;
    }

    @Override
    public int compare(Object o1, Object o2) {
        switch (type) {
            case "Integer":
                if (DESC.getName().equals(orderby)) {
                    return compareIntDesc(o1, o2);
                }
                return compareInt(o1, o2);

            case "String":
                if (DESC.getName().equals(orderby)) {
                    return compareStrDesc(o1, o2);
                }
                return compareStr(o1, o2);

            default:
                return 0;
        }
    }

    private int compareInt(Object o1, Object o2) {
        int b1 = ReflectUtil.getIntValue(o1, compareStr);
        int b2 = ReflectUtil.getIntValue(o2, compareStr);
        if (b1 < b2) {
            return -1;
        } else if (b1 > b2) {
            return 1;
        }
        return 0;
    }

    private int compareIntDesc(Object o1, Object o2) {
        int b1 = ReflectUtil.getIntValue(o1, compareStr);
        int b2 = ReflectUtil.getIntValue(o2, compareStr);
        if (b1 < b2) {
            return 1;
        } else if (b1 > b2) {
            return -1;
        }
        return 0;
    }


    private int compareStr(Object o1, Object o2) {
        return comparator.compare(ReflectUtil.getStrValue(o1, compareStr), ReflectUtil.getStrValue(o2, compareStr));
    }

    private int compareStrDesc(Object o1, Object o2) {
        return comparator.compare(ReflectUtil.getStrValue(o2, compareStr), ReflectUtil.getStrValue(o1, compareStr));
    }
}
