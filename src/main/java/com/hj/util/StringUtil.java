package com.hj.util;

import org.thymeleaf.util.StringUtils;

/**
 * Author: hj
 * Date: 2019-05-17 16:55
 * Description: <描述>
 */
public class StringUtil {

    /**
     * 字符串截取
     * "/Users/huangjie/Desktop/pictures/images/" + photoName
     * 上面的字符串路径只需要 images/" + photoName
     */
    public static String sub(String path) {
        String substring = StringUtils.substring(path, 33);
        return substring;
    }

    /**
     * 字符串截取（远程服务器静态资源路径）
     * "/home/www/static/images/" + photoName
     * 上面的字符串路径只需要 images/" + photoName
     */
    public static String sub1(String path) {
        String substring = StringUtils.substring(path, 17);
        return substring;
    }

}
