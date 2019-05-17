package com.github.imaginary11.bionicutils.model;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import lombok.Data;

import java.util.List;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/4/23 14:29
 */
@Data
public class EasyExcelModel {
    private List<? extends BaseRowModel> data;
    private Sheet sheet;

}
