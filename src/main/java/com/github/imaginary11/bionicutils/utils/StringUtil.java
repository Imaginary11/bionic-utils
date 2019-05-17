package com.github.imaginary11.bionicutils.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2018/12/3 11:28
 */
public class StringUtil {
    private static final String RANDOM_CHARACTER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 获取随机数uuid
     *
     * @return
     */
    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取随机长度字符串，数字加大写字母
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer(RANDOM_CHARACTER);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj.toString().trim());
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取两字符串的相似度
     */

    public static float getSimilarityRatio(String str, String target) {
        return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
    }


    private static int min(int one, int two, int three) {
        return (one = one < two ? one : two) < three ? one : three;
    }


    private static int compare(String str, String target) {
        int[][] d;
        int n = str.length();
        int m = target.length();
        int i;
        int j;
        char ch1;
        char ch2;
        int temp;
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) {
            ch1 = str.charAt(i - 1);
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

}
