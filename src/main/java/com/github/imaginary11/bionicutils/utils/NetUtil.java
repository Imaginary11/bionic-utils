package com.github.imaginary11.bionicutils.utils;

/**
 * @author chichen@corp.netease.com
 * @date 2018-07-17 10:37
 **/
public class NetUtil {
    private static boolean ping(String host) {
        try {
            boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

            ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
            Process proc = processBuilder.start();

            int returnVal = proc.waitFor();
            return returnVal == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取一个ping通的ip
     *
     * @param ipAddrs ip数组
     * @return ip
     */
    public static String getOneUseFullIp(String[] ipAddrs) {
        String ip = "";
        for (int i = 0; i < ipAddrs.length; i++) {
            ip = ipAddrs[i];
            if (ping(ip)) {
                break;
            }
        }
        return ip;
    }

}
