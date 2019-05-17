package com.github.imaginary11.bionicutils.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2018/8/10 17:49
 */
@Data
public class PageResult<T> {

    /**
     * Page size, default is 20
     */
    private int pagesize = 20;

    /**
     * Page number, Start with 1
     */
    private int page = 1;

    /**
     * Total number of results
     */
    private long total = 0;

    /**
     * The total number of pages
     */

    /**
     * Query result list
     */
    private List<T> lists = new ArrayList<>();


}
