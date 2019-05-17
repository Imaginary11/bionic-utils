package com.github.imaginary11.bionicutils;

import com.github.imaginary11.bionicutils.utils.RegxUtil;
import org.junit.Test;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/3/22 11:41
 */
public class RegxTest {
    @Test
    public void test() {
        boolean success = RegxUtil.isPassword("a./asdasasd");
        System.out.println(success);
    }
}
