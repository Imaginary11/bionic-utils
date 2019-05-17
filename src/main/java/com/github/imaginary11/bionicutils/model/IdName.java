package com.github.imaginary11.bionicutils.model;

import lombok.Data;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/3/4 17:47
 */
@Data
public class IdName {
    private Integer id;
    private String name;

    public IdName(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public IdName() {
    }
}
