package com.github.imaginary11.bionicutils;

import com.github.imaginary11.bionicutils.enums.OrderByEnums;
import com.github.imaginary11.bionicutils.model.IdName;
import com.github.imaginary11.bionicutils.utils.CollectionUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/4/9 12:31
 */
public class CollectionUtilTest {
    @Test
    public void testIsListEquals() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(1, 2, 3);
        Assert.assertTrue(CollectionUtil.isListEquals(a, b));
        List<Integer> c = Arrays.asList(1, 2, 3, 4);
        Assert.assertFalse(CollectionUtil.isListEquals(c, b));
    }

    @Test
    public void testSortObjList() {
        List<IdName> listA = Arrays.asList(new IdName(1, "A"),
                new IdName(5, "C"), new IdName(3, "B"));

        CollectionUtil.sortObjList(listA, "id", Integer.class, OrderByEnums.ASC);
        System.out.println(listA);
        CollectionUtil.sortObjList(listA, "id", String.class, OrderByEnums.DESC);
        System.out.println(listA);
    }


    @Test
    public void testList() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = new ArrayList<>();
        b.addAll(a);
        a = new ArrayList<>();
        a.addAll(Arrays.asList(4, 5, 6));
        System.out.println("a" + a);
        System.out.println("b" + b);
    }
}
