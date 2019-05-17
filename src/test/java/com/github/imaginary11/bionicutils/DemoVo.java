package com.github.imaginary11.bionicutils;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/4/22 11:14
 */
@Data
public class DemoVo extends BaseRowModel {
    @ExcelProperty(value = "名称", index = 2)
    private String name;
    @ExcelProperty(value = "UID", index = 1)
    private String uid;

    public DemoVo(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }
}
