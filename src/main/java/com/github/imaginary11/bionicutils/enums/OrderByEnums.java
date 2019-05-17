package com.github.imaginary11.bionicutils.enums;

/**
 * 排序枚举类
 *
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/3/8 14:41
 */
public enum OrderByEnums {
    DESC(-1, "desc"),
    ASC(1, "asc");
    private int code;
    private String name;

    OrderByEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static OrderByEnums getEnums(int code) {
        for (OrderByEnums orderByEnums : OrderByEnums.values()) {
            if (orderByEnums.getCode() == code) {
                return orderByEnums;
            }
        }
        return null;
    }

    public static OrderByEnums getEnums(String name) {
        for (OrderByEnums orderByEnums : OrderByEnums.values()) {
            if (orderByEnums.getName().equalsIgnoreCase(name)) {
                return orderByEnums;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
