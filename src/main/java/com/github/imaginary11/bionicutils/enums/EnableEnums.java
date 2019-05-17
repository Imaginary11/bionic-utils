package com.github.imaginary11.bionicutils.enums;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/3/6 17:51
 */
public enum EnableEnums {
    ENABLE(1, "启用"), DISABLE(0, "禁用");
    private Integer code;
    private String name;

    EnableEnums(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EnableEnums getEnums(int code) {
        for (EnableEnums enableEnums : EnableEnums.values()) {
            if (enableEnums.getCode() == code) {
                return enableEnums;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
