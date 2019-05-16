package com.hj.entity;

import lombok.Data;

/**
 * Author: hj
 * Date: 2019-05-16 16:37
 * Description: <描述>
 */
@Data
public class Picture {

    //图片id
    private Long id;

    //图片字节
    private byte[] pic;

    //图片描述
    private String description;
}
